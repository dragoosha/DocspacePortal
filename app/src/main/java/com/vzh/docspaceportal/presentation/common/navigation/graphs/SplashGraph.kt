package com.vzh.docspaceportal.presentation.common.navigation.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.vzh.docspaceportal.presentation.common.navigation.AppRoute
import com.vzh.docspaceportal.presentation.screens.splashScreen.SplashScreen

fun NavGraphBuilder.splashNavGraph(navController: NavController, token: String?) {
    composable(AppRoute.Splash.route) {
        SplashScreen(navController, token)
    }
}