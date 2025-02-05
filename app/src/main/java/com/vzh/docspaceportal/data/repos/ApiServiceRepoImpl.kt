package com.vzh.docspaceportal.data.repos

import com.vzh.docspaceportal.data.mappers.toDomainModel
import com.vzh.docspaceportal.data.models.AuthRequestParams
import com.vzh.docspaceportal.data.models.dto.AuthResponseDto
import com.vzh.docspaceportal.data.remote.ApiService
import com.vzh.docspaceportal.domain.common.Result
import com.vzh.docspaceportal.domain.model.AuthModel
import com.vzh.docspaceportal.domain.repos.ApiServiceRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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
}