package com.vzh.docspaceportal.domain.repos

import com.vzh.docspaceportal.data.models.dto.myDocumentsDto.MyDocumentsDto
import com.vzh.docspaceportal.domain.common.Result
import com.vzh.docspaceportal.domain.model.AuthModel
import com.vzh.docspaceportal.domain.model.MyDocumentsModel

interface ApiServiceRepo {
    suspend fun authenticateUser(
        portal: String,
        email: String,
        password: String,
    ): Result<AuthModel>

    suspend fun getMyFiles(
        authKey: String
    ): Result<MyDocumentsModel>
}