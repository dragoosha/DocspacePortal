package com.vzh.docspaceportal.data.models.dto.filesDto

import com.google.gson.annotations.SerializedName

data class CreatedBy(
    @SerializedName("avatar") val avatar: String?,
    @SerializedName("avatarMax") val avatarMax: String?,
    @SerializedName("avatarMedium") val avatarMedium: String?,
    @SerializedName("avatarOriginal") val avatarOriginal: String?,
    @SerializedName("avatarSmall") val avatarSmall: String?,
    @SerializedName("displayName") val displayName: String?,
    @SerializedName("hasAvatar") val hasAvatar: Boolean?,
    @SerializedName("id") val id: String?,
    @SerializedName("isAnonim") val isAnonim: Boolean?,
    @SerializedName("profileUrl") val profileUrl: String?
)