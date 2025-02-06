package com.vzh.docspaceportal.presentation.screens.documentsScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.vzh.docspaceportal.R
import com.vzh.docspaceportal.presentation.common.components.FilesLayout
import com.vzh.docspaceportal.presentation.common.components.LoadingIndicator
import com.vzh.docspaceportal.presentation.common.components.NoInternetStub
import com.vzh.docspaceportal.presentation.common.utils.hasNetwork
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel

@Composable
fun DocumentsScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val context = LocalContext.current

    var isInternetAvailable by rememberSaveable { mutableStateOf(true) }
    var isLoading by rememberSaveable { mutableStateOf(true) }


    LaunchedEffect(context) {
        delay(2000)
        isInternetAvailable = context.hasNetwork()
        isLoading = false
    }

    if (isLoading) {
        LoadingIndicator()
        return
    }

    if (!isInternetAvailable) {
        NoInternetStub(
            onRetryClicked = {
                isLoading = true
                isInternetAvailable = context.hasNetwork()
                isLoading = false
            }
        )
        return
    } else {

        val viewModel: DocumentsScreenViewModel = koinViewModel()
        val state = viewModel.documentsUiState.collectAsState().value

        FilesLayout(
            state = state.uiItem,
            onFileClicked = {},
            onFolderClicked = { id, label ->
                if (context.hasNetwork()) {
                    navController.navigate("main/$id/$label")
                } else {
                    isInternetAvailable = false
                }
            },
            label = stringResource(R.string.documents)
        )
    }
}

