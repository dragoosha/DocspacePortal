package com.vzh.docspaceportal.domain.usecase

import com.vzh.docspaceportal.domain.common.Result
import com.vzh.docspaceportal.domain.model.AuthModel
import com.vzh.docspaceportal.domain.repos.ApiServiceRepo
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AuthUseCase: KoinComponent {
    private val api: ApiServiceRepo by inject()

    suspend operator fun invoke(
        portal: String,
        email: String,
        password: String
    ): Result<AuthModel> {
        if (!isEmailValid(email)) {
            throw IllegalArgumentException("Invalid email format")
        }

        if (!isPasswordValid(password)) {
            throw IllegalArgumentException("Password must be at least 8 characters long")
        }

        return api.authenticateUser(portal, email, password)
    }

    private fun isEmailValid(email: String): Boolean {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"
        return email.matches(emailRegex.toRegex())
    }

    private fun isPasswordValid(password: String): Boolean {
        return password.length >= 8
    }

}