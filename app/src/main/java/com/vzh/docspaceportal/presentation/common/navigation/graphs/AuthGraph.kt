package com.vzh.docspaceportal.presentation.common.navigation.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.vzh.docspaceportal.presentation.common.navigation.AppRoute
import com.vzh.docspaceportal.presentation.screens.loginScreen.LoginScreen

fun NavGraphBuilder.authNavGraph(navController: NavController) {
    navigation(startDestination = AppRoute.Login.route, route = AppRoute.Auth.route) {
        composable(AppRoute.Login.route) {
            LoginScreen(
                navController = navController
            )
        }
    }
}