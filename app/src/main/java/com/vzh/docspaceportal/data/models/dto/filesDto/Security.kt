package com.vzh.docspaceportal.data.models.dto.filesDto

import com.google.gson.annotations.SerializedName

data class Security(
    @SerializedName("ChangeOwner") val ChangeOwner: Boolean?,
    @SerializedName("Copy") val Copy: Boolean?,
    @SerializedName("CopyLink") val CopyLink: Boolean?,
    @SerializedName("CopySharedLink") val CopySharedLink: Boolean?,
    @SerializedName("CopyTo") val CopyTo: Boolean?,
    @SerializedName("Create") val Create: Boolean?,
    @SerializedName("CreateRoomFrom") val CreateRoomFrom: Boolean?,
    @SerializedName("Delete") val Delete: Boolean?,
    @SerializedName("Download") val Download: Boolean?,
    @SerializedName("Duplicate") val Duplicate: Boolean?,
    @SerializedName("EditAccess") val EditAccess: Boolean?,
    @SerializedName("EditRoom") val EditRoom: Boolean?,
    @SerializedName("Embed") val Embed: Boolean?,
    @SerializedName("IndexExport") val IndexExport: Boolean?,
    @SerializedName("Move") val Move: Boolean?,
    @SerializedName("MoveTo") val MoveTo: Boolean?,
    @SerializedName("Mute") val Mute: Boolean?,
    @SerializedName("Pin") val Pin: Boolean?,
    @SerializedName("Read") val Read: Boolean?,
    @SerializedName("Reconnect") val Reconnect: Boolean?,
    @SerializedName("Rename") val Rename: Boolean?
)