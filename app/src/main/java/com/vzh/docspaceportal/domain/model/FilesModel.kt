package com.vzh.docspaceportal.domain.model

data class FilesModel(
    val files: List<FileModel>?,
    val folders: List<FolderModel>?
)


data class FileModel (
    val title: String?
)

data class FolderModel (
    val folderId: Int?,
    val title: String?
)