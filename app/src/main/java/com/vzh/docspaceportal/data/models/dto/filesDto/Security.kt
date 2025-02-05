package com.vzh.docspaceportal.data.models.dto.filesDto

data class Security(
    val ChangeOwner: Boolean,
    val Copy: Boolean,
    val CopyLink: Boolean,
    val CopySharedLink: Boolean,
    val CopyTo: Boolean,
    val Create: Boolean,
    val CreateRoomFrom: Boolean,
    val Delete: Boolean,
    val Download: Boolean,
    val Duplicate: Boolean,
    val EditAccess: Boolean,
    val EditRoom: Boolean,
    val Embed: Boolean,
    val IndexExport: Boolean,
    val Move: Boolean,
    val MoveTo: Boolean,
    val Mute: Boolean,
    val Pin: Boolean,
    val Read: Boolean,
    val Reconnect: Boolean,
    val Rename: Boolean
)