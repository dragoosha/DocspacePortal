package com.vzh.docspaceportal.data.models.dto.filesDto

data class CreatedBy(
    val avatar: String,
    val avatarMax: String,
    val avatarMedium: String,
    val avatarOriginal: String,
    val avatarSmall: String,
    val displayName: String,
    val hasAvatar: Boolean,
    val id: String,
    val isAnonim: Boolean,
    val profileUrl: String
)