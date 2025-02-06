package com.vzh.docspaceportal.presentation.common.navigation.graphs

import androidx.compose.material3.Scaffold
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.vzh.docspaceportal.presentation.common.navigation.AppRoute
import com.vzh.docspaceportal.presentation.common.navigation.bottomBar.BottomNavigationBar

fun NavGraphBuilder.mainNavGraph(navController: NavController) {
    navigation(startDestination = AppRoute.Documents.route, route = AppRoute.Main.route) {
        composable(AppRoute.Documents.route) {
            Scaffold(
                bottomBar = { BottomNavigationBar(navController) }
            ) {  }
        }
    }
}