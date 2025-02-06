package com.vzh.docspaceportal.data.models.dto.logoutDto

import com.google.gson.annotations.SerializedName

data class LogOutDto(
    @SerializedName("count") val count: Int,
    @SerializedName("links") val links: List<Link>,
    @SerializedName("status") val status: Int,
    @SerializedName("statusCode") val statusCode: Int
)