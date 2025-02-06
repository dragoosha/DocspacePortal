package com.vzh.docspaceportal.data.models.dto.filesDto

import com.google.gson.annotations.SerializedName

data class FilesDto(
    @SerializedName("count") val count: Int?,
    @SerializedName("links") val links: List<Link>?,
    @SerializedName("response") val response: Response?,
    @SerializedName("status") val status: Int?,
    @SerializedName("statusCode") val statusCode: Int?
)