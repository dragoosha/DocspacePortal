package com.vzh.docspaceportal.data.models.dto.logoutDto

data class LogOutDto(
    val count: Int,
    val links: List<Link>,
    val status: Int,
    val statusCode: Int
)