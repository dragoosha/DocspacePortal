package com.vzh.docspaceportal.data.models

import com.google.gson.annotations.SerializedName

data class AuthRequestParams(
    @SerializedName("userName") val userName: String,
    @SerializedName("password") val password: String
)