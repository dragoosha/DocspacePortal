package com.vzh.docspaceportal.data.models.dto.profileDto

data class ProfileDto(
    val count: Int,
    val links: List<Link>,
    val response: Response,
    val status: Int,
    val statusCode: Int
)