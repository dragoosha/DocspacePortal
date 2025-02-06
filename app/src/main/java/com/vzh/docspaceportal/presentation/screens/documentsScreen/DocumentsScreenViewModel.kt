package com.vzh.docspaceportal.presentation.screens.documentsScreen

import androidx.datastore.core.DataStore
import androidx.lifecycle.viewModelScope
import com.vzh.docspaceportal.domain.common.Result
import com.vzh.docspaceportal.domain.usecase.MyDocumentsUseCase
import com.vzh.docspaceportal.presentation.common.models.FileUi
import com.vzh.docspaceportal.presentation.common.models.FolderUi
import com.vzh.docspaceportal.presentation.common.utils.StatefulViewModel
import com.vzh.docspaceportal.presentation.common.utils.UserSettings
import com.vzh.docspaceportal.presentation.common.utils.toUiDocuments
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class DocumentsScreenViewModel(
    private val myDocumentsUseCase: MyDocumentsUseCase,
    private val dataStore: DataStore<UserSettings>
): StatefulViewModel<DocumentsUiState>(DocumentsUiState()) {

    val documentsUiState: StateFlow<DocumentsUiState>
        get() = stateFlow.stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = state
        )

    init {
        viewModelScope.launch {
            val userSettings = dataStore.data.first()

            val result = myDocumentsUseCase(userSettings.portal, userSettings.token)
            updateState {
                when(result) {
                    is Result.Error -> {
                        copy(errorMessage = result.message)
                    }
                    is Result.Success -> {
                        copy(uiItem = result.data?.toUiDocuments() ?: DocumentsUiItem())
                    }
                }
            }

        }
    }
}

data class DocumentsUiState(
    val uiItem: DocumentsUiItem = DocumentsUiItem(),
    val errorMessage: String? = null
)

data class DocumentsUiItem (
    val folders: List<FolderUi>? = null,
    val files: List<FileUi>? = null
)