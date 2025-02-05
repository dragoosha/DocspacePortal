package com.vzh.docspaceportal.data.mappers

import com.vzh.docspaceportal.data.models.dto.AuthResponseDto
import com.vzh.docspaceportal.domain.model.AuthModel

fun AuthResponseDto.toDomainModel() : AuthModel {
    return AuthModel(
        token = this.response.token,
        expires = this.response.expires
    )
}