package com.vzh.docspaceportal.presentation.screens.trashScreen

import androidx.datastore.core.DataStore
import androidx.lifecycle.viewModelScope
import com.vzh.docspaceportal.domain.common.Result
import com.vzh.docspaceportal.domain.usecase.GetTrashUseCase
import com.vzh.docspaceportal.presentation.common.models.FileUi
import com.vzh.docspaceportal.presentation.common.models.FilesUiItem
import com.vzh.docspaceportal.presentation.common.models.FolderUi
import com.vzh.docspaceportal.presentation.common.utils.StatefulViewModel
import com.vzh.docspaceportal.presentation.common.utils.UserSettings
import com.vzh.docspaceportal.presentation.common.utils.toUiItem
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TrashScreenViewModel(
    private val getTrashUseCase: GetTrashUseCase,
    private val dataStore: DataStore<UserSettings>
): StatefulViewModel<TrashUiState>(TrashUiState()) {

    val trashUiState: StateFlow<TrashUiState>
        get() = stateFlow.stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = state
        )

    init {
        viewModelScope.launch {
            val userSettings = dataStore.data.first()

            val result = getTrashUseCase(userSettings.portal, userSettings.token)
            updateState {
                when(result) {
                    is Result.Error -> {
                        copy(errorMessage = result.message)
                    }
                    is Result.Success -> {
                        copy(uiItem = result.data?.toUiItem(::TrashUiItem) ?: TrashUiItem())
                    }
                }
            }

        }
    }
}

data class TrashUiState(
    val uiItem: TrashUiItem = TrashUiItem(),
    val errorMessage: String? = null
)

data class TrashUiItem (
    override val folders: List<FolderUi>? = null,
    override val files: List<FileUi>? = null
): FilesUiItem