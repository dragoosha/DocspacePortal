package com.vzh.docspaceportal.presentation.screens.documentsScreen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.vzh.docspaceportal.R
import com.vzh.docspaceportal.presentation.common.components.CustomItem
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

