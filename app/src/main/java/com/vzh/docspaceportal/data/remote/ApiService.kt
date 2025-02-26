package com.vzh.docspaceportal.data.remote

import com.vzh.docspaceportal.data.models.AuthRequestParams
import com.vzh.docspaceportal.data.models.dto.authDto.AuthResponseDto
import com.vzh.docspaceportal.data.models.dto.filesDto.FilesDto
import com.vzh.docspaceportal.data.models.dto.logoutDto.LogOutDto
import com.vzh.docspaceportal.data.models.dto.profileDto.ProfileDto
import retrofit2.Call
import retrofit2.Response
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
    ): Response<AuthResponseDto>


    @GET
    suspend fun getMyFiles(
        @Url portalUrl: String,
        @Header("Cookie") authKey: String
    ): Response<FilesDto>


    @GET
    suspend fun getFolderFilesById(
        @Url portalUrl: String,
        @Header("Cookie") authKey: String
    ): Response<FilesDto>

    @GET
    suspend fun getMyProfile(
        @Url portalUrl: String,
        @Header("Cookie") authKey: String
    ): Response<ProfileDto>

    @GET
    suspend fun getMyRooms(
        @Url portalUrl: String,
        @Header("Cookie") authKey: String
    ): Response<FilesDto>

    @GET
    suspend fun getMyTrash(
        @Url portalUrl: String,
        @Header("Cookie") authKey: String
    ): Response<FilesDto>

    @GET
    suspend fun logout(
        @Url portalUrl: String,
        @Header("Cookie") authKey: String
    ): Response<LogOutDto>
}