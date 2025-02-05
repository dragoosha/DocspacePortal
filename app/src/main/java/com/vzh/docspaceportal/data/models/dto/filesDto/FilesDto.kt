package com.vzh.docspaceportal.data.models.dto.filesDto

data class FilesDto(
    val count: Int?,
    val links: List<Link>?,
    val response: Response?,
    val status: Int?,
    val statusCode: Int?
)