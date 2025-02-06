package com.vzh.docspaceportal.presentation.screens.documentsScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.vzh.docspaceportal.presentation.common.components.FilesLayout
import org.koin.androidx.compose.koinViewModel

@Composable
fun DocumentsScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    val viewModel: DocumentsScreenViewModel = koinViewModel()
    val state = viewModel.documentsUiState.collectAsState().value

    FilesLayout(
        state = state.uiItem,
        onFileClicked = {},
        onFolderClicked = {}
    )

}

