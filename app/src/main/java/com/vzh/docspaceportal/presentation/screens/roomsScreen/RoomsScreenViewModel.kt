package com.vzh.docspaceportal.presentation.screens.roomsScreen

import androidx.datastore.core.DataStore
import androidx.lifecycle.viewModelScope
import com.vzh.docspaceportal.domain.common.Result
import com.vzh.docspaceportal.domain.usecase.GetRoomsUseCase
import com.vzh.docspaceportal.presentation.common.models.FileUi
import com.vzh.docspaceportal.presentation.common.models.FilesUiItem
import com.vzh.docspaceportal.presentation.common.models.FolderUi
import com.vzh.docspaceportal.presentation.common.utils.StatefulViewModel
import com.vzh.docspaceportal.presentation.common.utils.UserSettings
import com.vzh.docspaceportal.presentation.common.utils.toUiRooms
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class RoomsScreenViewModel(
    private val getRoomsUseCase: GetRoomsUseCase,
    private val dataStore: DataStore<UserSettings>
):StatefulViewModel<RoomsUiState>(RoomsUiState()) {

    val roomsUiState: StateFlow<RoomsUiState>
        get() = stateFlow.stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = state
        )

    init {
        viewModelScope.launch {
            val userSettings = dataStore.data.first()

            val result = getRoomsUseCase(userSettings.portal, userSettings.token)
            updateState {
                when(result) {
                    is Result.Error -> {
                        copy(errorMessage = result.message)
                    }
                    is Result.Success -> {
                        copy(uiItem = result.data?.toUiRooms() ?: RoomsUiItem())
                    }
                }
            }

        }
    }
}

data class RoomsUiState(
    val uiItem: RoomsUiItem = RoomsUiItem(),
    val errorMessage: String? = null
)

data class RoomsUiItem (
    override val folders: List<FolderUi>? = null,
    override val files: List<FileUi>? = null
): FilesUiItem