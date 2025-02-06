package com.vzh.docspaceportal.presentation.common.utils

import com.vzh.docspaceportal.domain.model.FileModel
import com.vzh.docspaceportal.domain.model.FilesModel
import com.vzh.docspaceportal.domain.model.FolderModel
import com.vzh.docspaceportal.domain.model.ProfileModel
import com.vzh.docspaceportal.presentation.common.models.FileUi
import com.vzh.docspaceportal.presentation.common.models.FilesUiItem
import com.vzh.docspaceportal.presentation.common.models.FolderUi
import com.vzh.docspaceportal.presentation.screens.profileScreen.ProfileUiItem

inline fun <reified T : FilesUiItem> FilesModel.toUiItem(factory: (List<FolderUi>?, List<FileUi>?) -> T): T {
    return factory(
        this.folders?.map { it.toUi() },
        this.files?.map { it.toUi() }
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

fun ProfileModel.toProfileUi(portal: String) : ProfileUiItem {
    return ProfileUiItem(
        name = name,
        imageUrl = portal + imageUrl,
        email = email
    )
}