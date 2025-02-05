package com.vzh.docspaceportal.data.remote

import com.vzh.docspaceportal.data.models.AuthRequestParams
import com.vzh.docspaceportal.data.models.dto.AuthResponseDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Url

interface ApiService {

    @POST
    fun authenticateUser(
        @Url portalUrl: String,
        @Body request: AuthRequestParams
    ): Call<AuthResponseDto>

}