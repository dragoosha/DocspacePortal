package com.vzh.docspaceportal.presentation.screens.roomsScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.vzh.docspaceportal.R
import com.vzh.docspaceportal.presentation.common.components.FilesLayout
import org.koin.androidx.compose.koinViewModel

@Composable
fun RoomsScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    val viewModel: RoomsScreenViewModel = koinViewModel()
    val state: RoomsUiState = viewModel.roomsUiState.collectAsState().value

    FilesLayout(
        state = state.uiItem,
        onFolderClicked = { folderId, title ->
            navController.navigate("main/$folderId/$title")
        },
        onFileClicked = {},
        label = stringResource(R.string.rooms)
    )
}