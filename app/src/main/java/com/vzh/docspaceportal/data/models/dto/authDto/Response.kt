package com.vzh.docspaceportal.data.models.dto.authDto

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("expires") val expires: String?,
    @SerializedName("sms") val sms: Boolean?,
    @SerializedName("tfa")val tfa: Boolean?,
    @SerializedName("token") val token: String?
)