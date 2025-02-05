package com.vzh.docspaceportal.data.remote

import com.vzh.docspaceportal.data.models.AuthRequestParams
import com.vzh.docspaceportal.data.models.dto.authDto.AuthResponseDto
import com.vzh.docspaceportal.data.models.dto.myDocumentsDto.MyDocumentsDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Url

interface ApiService {

    @POST
    suspend fun authenticateUser(
        @Url portalUrl: String,
        @Body request: AuthRequestParams
    ): Call<AuthResponseDto>


    @GET
    suspend fun getMyFiles(
        @Url portalUrl: String,
        @Header("Cookie") authKey: String
    ): Call<MyDocumentsDto>


    @GET
    suspend fun getFolderFilesById(
        @Url portalUrl: String,
        @Header("Cookie") authKey: String
    ): Call<MyDocumentsDto>
}