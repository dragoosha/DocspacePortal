package com.vzh.docspaceportal.presentation.screens.trashScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.vzh.docspaceportal.R
import com.vzh.docspaceportal.presentation.common.components.FilesLayout
import org.koin.androidx.compose.koinViewModel

@Composable
fun TrashScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val viewModel: TrashScreenViewModel = koinViewModel()
    val state: TrashUiState = viewModel.trashUiState.collectAsState().value
    FilesLayout(
        state = state.uiItem,
        onFolderClicked = {id, label ->
            navController.navigate("main/$id/$label")
        },
        onFileClicked = {},
        label = stringResource(R.string.trash)
    )

}