package com.vzh.docspaceportal.presentation.common.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.vzh.docspaceportal.presentation.common.navigation.graphs.authNavGraph
import com.vzh.docspaceportal.presentation.common.navigation.graphs.mainNavGraph
import com.vzh.docspaceportal.presentation.common.navigation.graphs.splashNavGraph

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavigation(
    token: String?
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppRoute.Splash.route
    ) {
        authNavGraph(navController)
        mainNavGraph(navController)
        splashNavGraph(navController, token)
    }

}