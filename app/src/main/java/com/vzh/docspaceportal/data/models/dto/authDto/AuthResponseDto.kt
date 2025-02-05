package com.vzh.docspaceportal.data.models.dto.authDto

data class AuthResponseDto(
    val count: Int?,
    val links: List<Link>?,
    val response: Response?,
    val status: Int?,
    val statusCode: Int?
)