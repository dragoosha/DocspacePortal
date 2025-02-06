package com.vzh.docspaceportal.presentation.screens.profileScreen

import androidx.datastore.core.DataStore
import androidx.lifecycle.viewModelScope
import com.vzh.docspaceportal.domain.common.Result
import com.vzh.docspaceportal.domain.usecase.GetProfileUseCase
import com.vzh.docspaceportal.domain.usecase.LogOutUseCase
import com.vzh.docspaceportal.presentation.common.utils.StatefulViewModel
import com.vzh.docspaceportal.presentation.common.utils.UserSettings
import com.vzh.docspaceportal.presentation.common.utils.toProfileUi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ProfileScreenViewModel(
    private val getProfileUseCase: GetProfileUseCase,
    private val logOutUseCase: LogOutUseCase,
    private val dataStore: DataStore<UserSettings>
): StatefulViewModel<ProfileUiState>(ProfileUiState()) {

    val profileUiState: StateFlow<ProfileUiState>
        get() = stateFlow.stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = state
        )


    init {
        viewModelScope.launch {
            val userSettings = dataStore.data.first()
            val result = getProfileUseCase(portal = userSettings.portal, token = userSettings.token)

            updateState {
                when(result) {
                    is Result.Success -> {
                        copy(
                            uiItem = result.data?.toProfileUi(userSettings.portal) ?: ProfileUiItem()
                        )
                    }

                    is Result.Error -> {
                        copy(errorMessage = result.message)
                    }
                }
            }
        }
    }

}

data class ProfileUiState(
    val uiItem: ProfileUiItem = ProfileUiItem(),
    val errorMessage: String? = null
)

data class ProfileUiItem(
    val name: String = "",
    val email: String = "",
    val imageUrl: String = ""
)