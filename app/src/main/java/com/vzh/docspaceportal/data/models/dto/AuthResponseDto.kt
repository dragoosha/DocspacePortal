package com.vzh.docspaceportal.data.models.dto

import com.vzh.docspaceportal.data.models.dto.utils.Link
import com.vzh.docspaceportal.data.models.dto.utils.Response

data class AuthResponseDto(
    val count: Int,
    val links: List<Link>,
    val response: Response,
    val status: Int,
    val statusCode: Int
)