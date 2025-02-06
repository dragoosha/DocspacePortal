package com.vzh.docspaceportal.presentation.screens.folderScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.vzh.docspaceportal.presentation.common.components.FilesLayout
import org.koin.androidx.compose.koinViewModel

@Composable
fun FolderScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    folderId: Int,
    title: String
) {

    val viewModel: FolderScreenViewModel = koinViewModel()
    val state: FolderUiState = viewModel.folderUiState.collectAsState().value

    LaunchedEffect(folderId) {
        viewModel.getFilesById(folderId)
    }

    FilesLayout(
        state = state.uiItem,
        onFolderClicked = { id, label ->
            navController.navigate("main/$id/$label")
        },
        onFileClicked = {},
        label = title
    )
}