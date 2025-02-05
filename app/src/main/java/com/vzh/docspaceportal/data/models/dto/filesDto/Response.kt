package com.vzh.docspaceportal.data.models.dto.filesDto

data class Response(
    val count: Int?,
    val current: Current?,
    val files: List<File>?,
    val folders: List<Folder>?,
    val new: Int?,
    val pathParts: List<PathPart>?,
    val startIndex: Int?,
    val total: Int?
)