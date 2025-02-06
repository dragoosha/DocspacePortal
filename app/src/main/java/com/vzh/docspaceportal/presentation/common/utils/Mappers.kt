package com.vzh.docspaceportal.presentation.common.utils

import com.vzh.docspaceportal.domain.model.FileModel
import com.vzh.docspaceportal.domain.model.FilesModel
import com.vzh.docspaceportal.domain.model.FolderModel
import com.vzh.docspaceportal.presentation.common.models.FileUi
import com.vzh.docspaceportal.presentation.common.models.FolderUi
import com.vzh.docspaceportal.presentation.screens.documentsScreen.DocumentsUiItem
import com.vzh.docspaceportal.presentation.screens.roomsScreen.RoomsUiItem
import com.vzh.docspaceportal.presentation.screens.trashScreen.TrashUiItem

fun FilesModel.toUiDocuments() : DocumentsUiItem {
    return DocumentsUiItem(
        folders = this.folders?.map { it.toUi() },
        files = this.files?.map { it.toUi() }
    )
}

fun FilesModel.toUiTrash() : TrashUiItem {
    return TrashUiItem(
        folders = this.folders?.map { it.toUi() },
        files = this.files?.map { it.toUi() }
    )
}

fun FilesModel.toUiRooms() : RoomsUiItem {
    return RoomsUiItem(
        folders = this.folders?.map { it.toUi() },
        files = this.files?.map { it.toUi() }
    )
}

fun FolderModel.toUi(): FolderUi {
    return FolderUi(
        folderId = folderId ?: 0,
        title = title ?: ""
    )
}

fun FileModel.toUi(): FileUi {
    return FileUi(
        title = title ?: ""
    )
}