package com.vzh.docspaceportal.data.models.dto.filesDto

import com.google.gson.annotations.SerializedName

data class ViewAccessibility(
    @SerializedName("CanConvert") val CanConvert: Boolean?,
    @SerializedName("CoAuhtoring") val CoAuhtoring: Boolean?,
    @SerializedName("ImageView") val ImageView: Boolean?,
    @SerializedName("MediaView") val MediaView: Boolean?,
    @SerializedName("MustConvert") val MustConvert: Boolean?,
    @SerializedName("WebComment") val WebComment: Boolean?,
    @SerializedName("WebCustomFilterEditing") val WebCustomFilterEditing: Boolean?,
    @SerializedName("WebEdit") val WebEdit: Boolean?,
    @SerializedName("WebRestrictedEditing") val WebRestrictedEditing: Boolean?,
    @SerializedName("WebReview") val WebReview: Boolean?,
    @SerializedName("WebView") val WebView: Boolean?
)