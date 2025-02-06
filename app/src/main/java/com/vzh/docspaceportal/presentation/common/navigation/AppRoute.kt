package com.vzh.docspaceportal.presentation.common.navigation

sealed class AppRoute(val route: String) {
    object Auth : AppRoute("auth")
    object Main : AppRoute("main")
    object Splash: AppRoute("splash")

    object Login : AppRoute("auth/login")



    object Documents: AppRoute("main/documents")
    object Rooms: AppRoute("main/rooms")
    object Trash: AppRoute("main/trash")
    object Profile: AppRoute("main/profile")

    object Folder: AppRoute("main/{folderId}/{title}")
}