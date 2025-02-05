package com.vzh.docspaceportal.data.models.dto.filesDto

data class AvailableExternalRights(
    val Comment: Boolean,
    val CustomFilter: Boolean,
    val Editing: Boolean,
    val None: Boolean,
    val Read: Boolean,
    val Restrict: Boolean,
    val Review: Boolean
)