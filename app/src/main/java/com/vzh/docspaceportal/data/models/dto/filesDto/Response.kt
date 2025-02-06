package com.vzh.docspaceportal.data.models.dto.filesDto

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("count") val count: Int?,
    @SerializedName("current") val current: Current?,
    @SerializedName("files") val files: List<File>?,
    @SerializedName("folders") val folders: List<Folder>?,
    @SerializedName("new") val new: Int?,
    @SerializedName("pathParts") val pathParts: List<PathPart>?,
    @SerializedName("startIndex") val startIndex: Int?,
    @SerializedName("total") val total: Int?
)