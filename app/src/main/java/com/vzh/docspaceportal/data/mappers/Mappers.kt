package com.vzh.docspaceportal.data.mappers

import com.vzh.docspaceportal.data.models.dto.authDto.AuthResponseDto
import com.vzh.docspaceportal.data.models.dto.filesDto.File
import com.vzh.docspaceportal.data.models.dto.filesDto.Folder
import com.vzh.docspaceportal.data.models.dto.filesDto.FilesDto
import com.vzh.docspaceportal.data.models.dto.profileDto.ProfileDto
import com.vzh.docspaceportal.domain.model.AuthModel
import com.vzh.docspaceportal.domain.model.FileModel
import com.vzh.docspaceportal.domain.model.FolderModel
import com.vzh.docspaceportal.domain.model.FilesModel
import com.vzh.docspaceportal.domain.model.ProfileModel

fun AuthResponseDto.toDomainModel() : AuthModel {
    return AuthModel(
        token = this.response?.token ?: "",
        expires = this.response?.expires?: ""
    )
}

fun FilesDto.toDomainModel(): FilesModel {
    return FilesModel(
        files = this.response?.files?.map{ it.toDomainModel() },
        folders = this.response?.folders?.map { it.toDomainModel() }
    )
}

fun ProfileDto.toDomainModel(): ProfileModel {
    return ProfileModel(
        name = this.response?.displayName ?: "",
        email = this.response?.email?: "",
        imageUrl = this.response?.avatarMax?: ""
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

