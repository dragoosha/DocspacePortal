package com.vzh.docspaceportal.presentation.common.models

interface FilesUiItem {
    val folders: List<FolderUi>?
    val files: List<FileUi>?
}