package com.vzh.docspaceportal.data.models.dto.filesDto

import com.google.gson.annotations.SerializedName

data class AvailableExternalRights(
    @SerializedName("Comment") val Comment: Boolean?,
    @SerializedName("CustomFilter") val CustomFilter: Boolean?,
    @SerializedName("Editing") val Editing: Boolean?,
    @SerializedName("None") val None: Boolean?,
    @SerializedName("Read") val Read: Boolean?,
    @SerializedName("Restrict") val Restrict: Boolean?,
    @SerializedName("Review") val Review: Boolean?
)