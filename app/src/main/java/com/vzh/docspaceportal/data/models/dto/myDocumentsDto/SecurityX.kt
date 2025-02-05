package com.vzh.docspaceportal.data.models.dto.myDocumentsDto

data class SecurityX(
    val Comment: Boolean,
    val Convert: Boolean,
    val Copy: Boolean,
    val CopyLink: Boolean,
    val CreateRoomFrom: Boolean,
    val CustomFilter: Boolean,
    val Delete: Boolean,
    val Download: Boolean,
    val Duplicate: Boolean,
    val Edit: Boolean,
    val EditHistory: Boolean,
    val Embed: Boolean,
    val FillForms: Boolean,
    val Lock: Boolean,
    val Move: Boolean,
    val Read: Boolean,
    val ReadHistory: Boolean,
    val Rename: Boolean,
    val Review: Boolean,
    val SubmitToFormGallery: Boolean
)