package com.vzh.docspaceportal.domain.repos

import com.vzh.docspaceportal.domain.common.Result
import com.vzh.docspaceportal.domain.model.AuthModel
import com.vzh.docspaceportal.domain.model.FilesModel
import com.vzh.docspaceportal.domain.model.ProfileModel

interface ApiServiceRepo {
    suspend fun authenticateUser(
        portal: String,
        email: String,
        password: String,
    ): Result<AuthModel>

    suspend fun getMyFiles(
        portal: String,
        authKey: String
    ): Result<FilesModel>

    suspend fun getFolderFilesById(
        id: Int,
        portal: String,
        authKey: String
    ): Result<FilesModel>

    suspend fun getMyProfile(
        portal: String,
        authKey: String
    ): Result<ProfileModel>

    suspend fun getMyRooms(
        portal: String,
        authKey: String
    ): Result<FilesModel>

    suspend fun getMyTrash(
        portal: String,
        authKey: String
    ): Result<FilesModel>

    suspend fun logOut(
        portal: String,
        authKey: String
    )
}