package com.vzh.docspaceportal.data.models.dto.authDto

import com.google.gson.annotations.SerializedName

data class AuthResponseDto(
    @SerializedName("count") val count: Int?,
    @SerializedName("links") val links: List<Link>?,
    @SerializedName("response") val response: Response?,
    @SerializedName("status") val status: Int?,
    @SerializedName("statusCode") val statusCode: Int?
)