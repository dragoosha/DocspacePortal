package com.vzh.docspaceportal.presentation.screens.loginScreen

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.lifecycle.viewModelScope
import com.vzh.docspaceportal.R
import com.vzh.docspaceportal.domain.common.Result
import com.vzh.docspaceportal.domain.usecase.AuthUseCase
import com.vzh.docspaceportal.presentation.common.utils.StatefulViewModel
import com.vzh.docspaceportal.presentation.common.utils.UserSettings
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class LoginScreenViewModel(
    private val authUseCase: AuthUseCase,
    private val dataStore: DataStore<UserSettings>
): StatefulViewModel<LoginState>(LoginState()), LoginController {

    val loginState: StateFlow<LoginState>
        get() = stateFlow.stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = state
        )

    override fun signUp(context: Context) {
        viewModelScope.launch {
            try {
                val result = authUseCase(
                    loginState.value.uiItem.portal,
                    loginState.value.uiItem.email,
                    loginState.value.uiItem.password
                )

                updateState {
                    when (result) {
                        is Result.Success -> {
                            viewModelScope.launch {
                                dataStore.updateData { currentSettings ->
                                    currentSettings.copy(
                                        portal = loginState.value.uiItem.portal,
                                        token = result.data?.token ?: "",
                                        expires = result.data?.expires ?: ""
                                    )
                                }
                            }

                            copy(
                                isAuthenticating = false,
                                authenticationSucceed = true,
                                authErrorMessage = null
                            )
                        }
                        is Result.Error -> {
                            val errorMessage = if (result.message?.contains("401") == true) {
                                context.getString(R.string.check_credits)
                            } else {
                                context.getString(R.string.unknown_error)
                            }

                            copy(
                                authErrorMessage = errorMessage,
                                isAuthenticating = false,
                                authenticationSucceed = false
                            )
                        }
                    }
                }
            } catch (e: Exception) {
                updateState {
                    copy(
                        isAuthenticating = false,
                        authenticationSucceed = false,
                        authErrorMessage = e.message ?: "Unknown error"
                    )
                }
            }
        }
    }


    override fun validateAndLogin(context: Context) {
        val currentState = loginState.value.uiItem

        val portalError = if (isValidPortal(currentState.portal)) null else context.getText(R.string.correct_portal).toString()
        val emailError = if (isValidEmail(currentState.email)) null else context.getText(R.string.correct_email).toString()
        val passwordError = if (isValidPassword(currentState.password)) null else context.getText(R.string.correct_password).toString()

        if (portalError == null && emailError == null && passwordError == null) {
            signUp(context)
        } else {
            updateState {
                copy(
                    uiItem = currentState.copy(
                        portalError = portalError,
                        emailError = emailError,
                        passwordError = passwordError
                    )
                )
            }
        }
    }

    override fun updatePortal(input: String) {
        val currentState = loginState.value.uiItem
        updateState { copy(
            uiItem = currentState.copy(
                portal = input
            )
        ) }
    }

    override fun updateEmail(input: String) {
        val currentState = loginState.value.uiItem
        updateState { copy(
            uiItem = currentState.copy(
                email = input
            )
        ) }

    }

    override fun updatePassword(input: String) {
        val currentState = loginState.value.uiItem
        updateState { copy(
            uiItem = currentState.copy(
                password = input
            )
        ) }
    }

    private fun isValidPortal(portal: String): Boolean {
        val urlRegex = "^(https?://)?(www\\.)?[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}(/.*)?$"
        return portal.matches(urlRegex.toRegex())
    }

    private fun isValidEmail(email: String): Boolean {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
        return email.matches(emailRegex.toRegex())
    }

    private fun isValidPassword(password: String): Boolean {
        return password.length >= 8
    }

}

interface LoginController {
    fun signUp(context: Context)
    fun validateAndLogin(context: Context)
    fun updatePortal(input: String)
    fun updateEmail(input: String)
    fun updatePassword(input: String)
}

data class LoginState(
    val uiItem: LoginUiItem = LoginUiItem(),
    var isAuthenticating: Boolean = false,
    var authErrorMessage: String? = null,
    var authenticationSucceed: Boolean = false
)

data class LoginUiItem(
    val portal: String = "",
    val email: String = "",
    val password: String = "",
    val portalError: String? = null,
    val emailError: String? = null,
    val passwordError: String? = null
)
