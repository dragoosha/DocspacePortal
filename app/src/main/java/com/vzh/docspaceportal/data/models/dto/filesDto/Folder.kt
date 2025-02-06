package com.vzh.docspaceportal.data.models.dto.filesDto

import com.google.gson.annotations.SerializedName

data class Folder(
    @SerializedName("access") val access: Int?,
    @SerializedName("canShare") val canShare: Boolean?,
    @SerializedName("created") val created: String?,
    @SerializedName("createdBy") val createdBy: CreatedBy?,
    @SerializedName("denyDownload") val denyDownload: Boolean?,
    @SerializedName("fileEntryType") val fileEntryType: Int?,
    @SerializedName("filesCount") val filesCount: Int?,
    @SerializedName("foldersCount") val foldersCount: Int?,
    @SerializedName("id") val id: Int?,
    @SerializedName("indexing") val indexing: Boolean?,
    @SerializedName("mute") val mute: Boolean?,
    @SerializedName("new") val new: Int?,
    @SerializedName("parentId") val parentId: Int?,
    @SerializedName("pinned") val pinned: Boolean?,
    @SerializedName("private") val `private`: Boolean?,
    @SerializedName("rootFolderId") val rootFolderId: Int?,
    @SerializedName("rootFolderType") val rootFolderType: Int?,
    @SerializedName("security") val security: Security?,
    @SerializedName("shared") val shared: Boolean?,
    @SerializedName("title") val title: String?,
    @SerializedName("updated") val updated: String?,
    @SerializedName("updatedBy") val updatedBy: UpdatedBy?
)