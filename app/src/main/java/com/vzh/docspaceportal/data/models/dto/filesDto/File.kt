package com.vzh.docspaceportal.data.models.dto.filesDto


import com.google.gson.annotations.SerializedName

data class File(
    @SerializedName("access") val access: Int?,
    @SerializedName("availableExternalRights") val availableExternalRights: AvailableExternalRights?,
    @SerializedName("canShare") val canShare: Boolean?,
    @SerializedName("comment") val comment: String?,
    @SerializedName("contentLength") val contentLength: String?,
    @SerializedName("created") val created: String?,
    @SerializedName("createdBy") val createdBy: CreatedBy?,
    @SerializedName("fileEntryType") val fileEntryType: Int?,
    @SerializedName("fileExst") val fileExst: String?,
    @SerializedName("fileStatus") val fileStatus: Int?,
    @SerializedName("fileType") val fileType: Int?,
    @SerializedName("folderId") val folderId: Int?,
    @SerializedName("hasDraft") val hasDraft: Boolean?,
    @SerializedName("id") val id: Int?,
    @SerializedName("isForm") val isForm: Boolean?,
    @SerializedName("mute") val mute: Boolean?,
    @SerializedName("pureContentLength") val pureContentLength: Int?,
    @SerializedName("rootFolderId") val rootFolderId: Int?,
    @SerializedName("rootFolderType") val rootFolderType: Int?,
    @SerializedName("security") val security: SecurityX?,
    @SerializedName("shared") val shared: Boolean?,
    @SerializedName("thumbnailStatus") val thumbnailStatus: Int?,
    @SerializedName("title") val title: String?,
    @SerializedName("updated") val updated: String?,
    @SerializedName("updatedBy") val updatedBy: UpdatedBy?,
    @SerializedName("version") val version: Int?,
    @SerializedName("versionGroup") val versionGroup: Int?,
    @SerializedName("viewAccessibility") val viewAccessibility: ViewAccessibility?,
    @SerializedName("viewUrl") val viewUrl: String?,
    @SerializedName("webUrl") val webUrl: String?
)