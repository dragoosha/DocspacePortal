package com.vzh.docspaceportal.data.models.dto.profileDto

import com.google.gson.annotations.SerializedName

data class ProfileDto(
    @SerializedName("count") val count: Int?,
    @SerializedName("links") val links: List<Link>?,
    @SerializedName("response") val response: Response?,
    @SerializedName("status") val status: Int?,
    @SerializedName("statusCode") val statusCode: Int?
)