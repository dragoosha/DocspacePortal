package com.vzh.docspaceportal.data.models.dto.myDocumentsDto

data class Current(
    val access: Int,
    val canShare: Boolean,
    val created: String,
    val createdBy: CreatedBy,
    val denyDownload: Boolean,
    val fileEntryType: Int,
    val filesCount: Int,
    val foldersCount: Int,
    val id: Int,
    val indexing: Boolean,
    val mute: Boolean,
    val new: Int,
    val parentId: Int,
    val pinned: Boolean,
    val `private`: Boolean,
    val rootFolderId: Int,
    val rootFolderType: Int,
    val security: Security,
    val shared: Boolean,
    val title: String,
    val updated: String,
    val updatedBy: UpdatedBy
)