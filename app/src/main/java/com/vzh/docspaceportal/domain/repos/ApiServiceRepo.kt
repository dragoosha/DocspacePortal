package com.vzh.docspaceportal.domain.repos

import com.vzh.docspaceportal.domain.common.Result
import com.vzh.docspaceportal.domain.model.AuthModel
import com.vzh.docspaceportal.domain.model.MyDocumentsModel
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
    ): Result<MyDocumentsModel>

    suspend fun getFolderFilesById(
        id: Int,
        portal: String,
        authKey: String
    ): Result<MyDocumentsModel>

    suspend fun getMyProfile(
        portal: String,
        authKey: String
    ): Result<ProfileModel>
}