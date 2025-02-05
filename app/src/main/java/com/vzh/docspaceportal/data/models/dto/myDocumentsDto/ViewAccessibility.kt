package com.vzh.docspaceportal.data.models.dto.myDocumentsDto

data class ViewAccessibility(
    val CanConvert: Boolean,
    val CoAuhtoring: Boolean,
    val ImageView: Boolean,
    val MediaView: Boolean,
    val MustConvert: Boolean,
    val WebComment: Boolean,
    val WebCustomFilterEditing: Boolean,
    val WebEdit: Boolean,
    val WebRestrictedEditing: Boolean,
    val WebReview: Boolean,
    val WebView: Boolean
)