package com.vzh.docspaceportal.presentation.common.navigation

sealed class AppRoute(val route: String) {
    object Auth : AppRoute("auth")
    object Main : AppRoute("main")

    object Login : AppRoute("auth/login")
}