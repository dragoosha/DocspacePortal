package com.vzh.docspaceportal.domain.repos

import com.vzh.docspaceportal.domain.common.Result
import com.vzh.docspaceportal.domain.model.AuthModel

interface ApiServiceRepo {
    suspend fun authenticateUser(
        portal: String,
        email: String,
        password: String,
    ): Result<AuthModel>
}