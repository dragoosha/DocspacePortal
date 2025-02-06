package com.vzh.docspaceportal.presentation.screens.folderScreen

import androidx.datastore.core.DataStore
import androidx.lifecycle.viewModelScope
import com.vzh.docspaceportal.domain.common.Result
import com.vzh.docspaceportal.domain.usecase.GetFileByIdUseCase
import com.vzh.docspaceportal.presentation.common.models.FileUi
import com.vzh.docspaceportal.presentation.common.models.FilesUiItem
import com.vzh.docspaceportal.presentation.common.models.FolderUi
import com.vzh.docspaceportal.presentation.common.utils.StatefulViewModel
import com.vzh.docspaceportal.presentation.common.utils.UserSettings
import com.vzh.docspaceportal.presentation.common.utils.toUiItem
import com.vzh.docspaceportal.presentation.screens.roomsScreen.RoomsUiState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class FolderScreenViewModel(
    private val getFileByIdUseCase: GetFileByIdUseCase,
    private val dataStore: DataStore<UserSettings>
): StatefulViewModel<FolderUiState>(FolderUiState()){

    val folderUiState: StateFlow<FolderUiState>
        get() = stateFlow.stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = state
        )

    fun getFilesById(id: Int) {
        viewModelScope.launch {
            val userSettings = dataStore.data.first()
            val result = getFileByIdUseCase(userSettings.portal, userSettings.token, id)

            updateState {
                when(result) {
                    is Result.Error -> {
                        copy(errorMessage = result.message )
                    }
                    is Result.Success -> {
                        copy(uiItem = result.data?.toUiItem(::FolderUiItem) ?: FolderUiItem())
                    }
                }
            }
        }
    }

}


data class FolderUiState(
    val uiItem: FolderUiItem = FolderUiItem(),
    val errorMessage: String? = null
)

data class FolderUiItem(
    override val folders: List<FolderUi>? = null,
    override val files: List<FileUi>? = null
): FilesUiItem