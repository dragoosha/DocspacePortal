package com.vzh.docspaceportal.data.models.dto.authDto

data class Response(
    val expires: String,
    val sms: Boolean,
    val tfa: Boolean,
    val token: String
)