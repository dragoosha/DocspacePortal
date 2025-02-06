package com.vzh.docspaceportal.data.models.dto.logoutDto

import com.google.gson.annotations.SerializedName

data class Link(
    @SerializedName("action") val action: String?,
    @SerializedName("href") val href: String?
)