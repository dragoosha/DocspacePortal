package com.vzh.docspaceportal.presentation.common.utils

import kotlinx.serialization.Serializable


@Serializable
data class UserSettings(
    val portal: String = "",
    val token: String = "",
    val expires: String = ""
)
