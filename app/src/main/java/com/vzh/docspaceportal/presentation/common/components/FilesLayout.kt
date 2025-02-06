package com.vzh.docspaceportal.presentation.common.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.vzh.docspaceportal.R
import com.vzh.docspaceportal.presentation.common.models.FilesUiItem
import com.vzh.docspaceportal.presentation.screens.documentsScreen.DocumentsUiItem

@Composable
fun <T : FilesUiItem> FilesLayout(
    modifier: Modifier = Modifier,
    state: T,
    onFolderClicked: (Int, String) -> Unit,
    onFileClicked: () -> Unit,
    label: String
) {

    LazyColumn(
        modifier = modifier.fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        item { Spacer(modifier = modifier.height(100.dp)) }

        item { Text(text = label, style= MaterialTheme.typography.headlineMedium) }

        item { Spacer(modifier = modifier.height(25.dp)) }

        state.folders?.let {
            items(it) {
                CustomItem(
                    text = it.title,
                    icon = R.drawable.baseline_folder_24,
                    onItemClicked = {onFolderClicked(it.folderId, it.title)}
                )
            }
        }

        state.files?.let {
            items(it) {
                CustomItem(
                    text = it.title,
                    icon = R.drawable.baseline_file_24,
                    onItemClicked = onFileClicked
                )

            }

        }
    }
}
