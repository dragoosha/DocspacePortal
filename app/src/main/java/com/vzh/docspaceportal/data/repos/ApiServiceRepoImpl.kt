package com.vzh.docspaceportal.data.repos

import com.vzh.docspaceportal.data.mappers.toDomainModel
import com.vzh.docspaceportal.data.models.AuthRequestParams
import com.vzh.docspaceportal.data.remote.ApiService
import com.vzh.docspaceportal.domain.common.Result
import com.vzh.docspaceportal.domain.model.AuthModel
import com.vzh.docspaceportal.domain.model.FilesModel
import com.vzh.docspaceportal.domain.model.ProfileModel
import com.vzh.docspaceportal.domain.repos.ApiServiceRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.awaitResponse

class ApiServiceRepoImpl(
    private val apiService: ApiService
): ApiServiceRepo {

    override suspend fun authenticateUser(
        portal: String,
        email: String,
        password: String
    ): Result<AuthModel> {
        return withContext(Dispatchers.IO) {
            val requestParams = AuthRequestParams(email, password)

            val call = apiService.authenticateUser("$portal/api/2.0/authentication", requestParams)

            try {
                val response = call.awaitResponse()
                val model = response.body()
                if (response.isSuccessful && model?.status == 0) {
                    Result.Success(
                        data = model.toDomainModel()
                    )
                } else {
                    Result.Error(
                        message = "Authentication error: ${response.code()}"
                    )
                }
            } catch (e: Exception) {
                Result.Error(
                    message = "Bad request: ${e.message}"
                )

            }
        }
    }

    override suspend fun getMyFiles(portal: String, authKey: String): Result<FilesModel> {
        return withContext(Dispatchers.IO) {
            val call = apiService.getMyFiles("$portal/api/2.0/files/@my","asc_auth_key=$authKey")

            return@withContext try {
                val response = call.awaitResponse()
                val model = response.body()

                if (response.isSuccessful && model?.status == 0) {
                    Result.Success(
                        data = model.toDomainModel()
                    )
                } else {
                    Result.Error(
                        message = "Failed to fetch data : ${response.code()}"
                    )
                }
            } catch (e: Exception) {
                Result.Error(
                    message = "Network error: ${e.message}"
                )
            }

        }
    }

    override suspend fun getFolderFilesById(
        id: Int,
        portal: String,
        authKey: String
    ): Result<FilesModel> {

        return withContext(Dispatchers.IO) {
            val call = apiService.getFolderFilesById("$portal/api/2.0/files/$id", "asc_auth_key=$authKey")

            return@withContext try {
                val response = call.awaitResponse()
                val model = response.body()

                if (response.isSuccessful && model?.status ==0) {
                    Result.Success(
                        data = model.toDomainModel()
                    )
                } else {
                    Result.Error(
                        message= "Failed to fetch data: ${response.code()}"
                    )
                }
            } catch (e: Exception) {
                Result.Error(
                    message = "Network error: ${e.message}"
                )
            }
        }

    }

    override suspend fun getMyProfile(portal: String, authKey: String): Result<ProfileModel> {
        return withContext(Dispatchers.IO) {
            val call = apiService.getMyProfile("$portal/api/2.0/people/@self", "asc_auth_key=$authKey" )
            return@withContext try {
                val response = call.awaitResponse()
                val model = response.body()

                if (response.isSuccessful && model?.status ==0) {
                    Result.Success(
                        data = model.toDomainModel()
                    )
                } else {
                    Result.Error(
                        message= "Failed to fetch data: ${response.code()}"
                    )
                }
            } catch (e: Exception) {
                Result.Error(
                    message = "Network error: ${e.message}"
                )
            }
        }
    }

    override suspend fun getMyRooms(portal: String, authKey: String): Result<FilesModel> {
        return withContext(Dispatchers.IO) {
            val call = apiService.getMyRooms("$portal/api/2.0/files/rooms", "asc_auth_key=$authKey")

            return@withContext try {
                val response = call.awaitResponse()
                val model = response.body()

                if (response.isSuccessful && model?.status ==0) {
                    Result.Success(
                        data = model.toDomainModel()
                    )
                } else {
                    Result.Error(
                        message= "Failed to fetch data: ${response.code()}"
                    )
                }
            } catch (e: Exception) {
                Result.Error(
                    message = "Network error: ${e.message}"
                )
            }
        }
    }

    override suspend fun getMyTrash(portal: String, authKey: String): Result<FilesModel> {
        return withContext(Dispatchers.IO) {
            val call = apiService.getMyTrash("$portal/api/2.0/files/@trash", "asc_auth_key=$authKey")

            return@withContext try {
                val response = call.awaitResponse()
                val model = response.body()

                if (response.isSuccessful && model?.status ==0) {
                    Result.Success(
                        data = model.toDomainModel()
                    )
                } else {
                    Result.Error(
                        message= "Failed to fetch data: ${response.code()}"
                    )
                }
            } catch (e: Exception) {
                Result.Error(
                    message = "Network error: ${e.message}"
                )
            }
        }
    }
}