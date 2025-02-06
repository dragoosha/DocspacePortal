package com.vzh.docspaceportal.data.models.dto.filesDto

import com.google.gson.annotations.SerializedName

data class PathPart(
    @SerializedName("id") val id: Int?,
    @SerializedName("title") val title: String?
)