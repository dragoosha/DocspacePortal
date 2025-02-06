package com.vzh.docspaceportal.data.models.dto.profileDto

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("activationStatus") val activationStatus: Int?,
    @SerializedName("avatar") val avatar: String?,
    @SerializedName("avatarMax") val avatarMax: String?,
    @SerializedName("avatarMedium") val avatarMedium: String?,
    @SerializedName("avatarOriginal") val avatarOriginal: String?,
    @SerializedName("avatarSmall") val avatarSmall: String?,
    @SerializedName("cultureName") val cultureName: String?,
    @SerializedName("department") val department: String?,
    @SerializedName("displayName") val displayName: String?,
    @SerializedName("email") val email: String?,
    @SerializedName("firstName") val firstName: String?,
    @SerializedName("hasAvatar") val hasAvatar: Boolean?,
    @SerializedName("id") val id: String?,
    @SerializedName("isAdmin") val isAdmin: Boolean?,
    @SerializedName("isAnonim") val isAnonim: Boolean?,
    @SerializedName("isCollaborator") val isCollaborator: Boolean?,
    @SerializedName("isLDAP") val isLDAP: Boolean?,
    @SerializedName("isOwner") val isOwner: Boolean?,
    @SerializedName("isRoomAdmin") val isRoomAdmin: Boolean?,
    @SerializedName("isSSO") val isSSO: Boolean?,
    @SerializedName("isVisitor") val isVisitor: Boolean?,
    @SerializedName("lastName") val lastName: String?,
    @SerializedName("loginEventId") val loginEventId: Int?,
    @SerializedName("mobilePhoneActivationStatus") val mobilePhoneActivationStatus: Int?,
    @SerializedName("profileUrl") val profileUrl: String?,
    @SerializedName("registrationDate") val registrationDate: String?,
    @SerializedName("status") val status: Int?,
    @SerializedName("theme") val theme: String?,
    @SerializedName("userName") val userName: String?,
    @SerializedName("workFrom") val workFrom: String?
)