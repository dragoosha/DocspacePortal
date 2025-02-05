package com.vzh.docspaceportal.data.mappers

import com.vzh.docspaceportal.data.models.dto.authDto.AuthResponseDto
import com.vzh.docspaceportal.data.models.dto.myDocumentsDto.File
import com.vzh.docspaceportal.data.models.dto.myDocumentsDto.Folder
import com.vzh.docspaceportal.data.models.dto.myDocumentsDto.MyDocumentsDto
import com.vzh.docspaceportal.domain.model.AuthModel
import com.vzh.docspaceportal.domain.model.FileModel
import com.vzh.docspaceportal.domain.model.FolderModel
import com.vzh.docspaceportal.domain.model.MyDocumentsModel

fun AuthResponseDto.toDomainModel() : AuthModel {
    return AuthModel(
        token = this.response.token,
        expires = this.response.expires
    )
}

fun MyDocumentsDto.toDomainModel(): MyDocumentsModel {
    return MyDocumentsModel(
        files = this.response.files.map{ it.toDomainModel() },
        folders = this.response.folders.map { it.toDomainModel() }
    )
}

fun File.toDomainModel() : FileModel {
    return FileModel(
        title = this.title
    )
}

fun Folder.toDomainModel() : FolderModel {
    return FolderModel(
        title = this.title,
        folderId = this.id
    )
}