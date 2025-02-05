package com.vzh.docspaceportal.data.models.dto.myDocumentsDto

data class MyDocumentsDto(
    val count: Int,
    val links: List<Link>,
    val response: Response,
    val status: Int,
    val statusCode: Int
)