package com.vzh.docspaceportal.presentation.screens.loginScreen

import androidx.datastore.core.DataStore
import androidx.lifecycle.viewModelScope
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

    override fun signUp() {
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
                            copy(
                                isAuthenticating = false,
                                authenticationSucceed = false,
                                authErrorMessage = result.message
                            )
                        }
                    }
                }
            } catch (e: Exception) {
                updateState {
                    copy(
                        isAuthenticating = false,
                        authenticationSucceed = false,
                        authErrorMessage = e.message ?: "Unexpected Error"
                    )
                }
            }
        }
    }


}

interface LoginController {
    fun signUp()
}

data class LoginState(
    val uiItem: LoginUiItem = LoginUiItem(),
    var isAuthenticating: Boolean = false,
    var authErrorMessage: String? = null,
    var authenticationSucceed: Boolean = false
)

data class LoginUiItem (
    val portal: String = "",
    val email: String = "",
    val password: String = ""
)