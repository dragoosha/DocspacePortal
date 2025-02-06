package com.vzh.docspaceportal.data.models.dto.filesDto

import com.google.gson.annotations.SerializedName

data class SecurityX(
    @SerializedName("Comment") val Comment: Boolean?,
    @SerializedName("Convert") val Convert: Boolean?,
    @SerializedName("Copy") val Copy: Boolean?,
    @SerializedName("CopyLink") val CopyLink: Boolean?,
    @SerializedName("CreateRoomFrom") val CreateRoomFrom: Boolean?,
    @SerializedName("CustomFilter") val CustomFilter: Boolean?,
    @SerializedName("Delete") val Delete: Boolean?,
    @SerializedName("Download") val Download: Boolean?,
    @SerializedName("Duplicate") val Duplicate: Boolean?,
    @SerializedName("Edit") val Edit: Boolean?,
    @SerializedName("EditHistory") val EditHistory: Boolean?,
    @SerializedName("Embed") val Embed: Boolean?,
    @SerializedName("FillForms") val FillForms: Boolean?,
    @SerializedName("Lock") val Lock: Boolean?,
    @SerializedName("Move") val Move: Boolean?,
    @SerializedName("Read") val Read: Boolean?,
    @SerializedName("ReadHistory") val ReadHistory: Boolean?,
    @SerializedName("Rename") val Rename: Boolean?,
    @SerializedName("Review") val Review: Boolean?,
    @SerializedName("SubmitToFormGallery") val SubmitToFormGallery: Boolean?
)