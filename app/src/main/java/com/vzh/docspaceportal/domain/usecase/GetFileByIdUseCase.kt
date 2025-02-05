package com.vzh.docspaceportal.domain.usecase

import com.vzh.docspaceportal.domain.common.Result
import com.vzh.docspaceportal.domain.model.FilesModel
import com.vzh.docspaceportal.domain.repos.ApiServiceRepo
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetFileByIdUseCase: KoinComponent {
    private val repo: ApiServiceRepo by inject()

    suspend operator fun invoke(portal: String, token: String): Result<FilesModel> {
        return repo.getMyFiles(portal, token)
    }
}