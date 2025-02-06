package com.vzh.docspaceportal.presentation.common.navigation.graphs

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.vzh.docspaceportal.presentation.common.navigation.AppRoute
import com.vzh.docspaceportal.presentation.common.navigation.bottomBar.BottomNavigationBar
import com.vzh.docspaceportal.presentation.screens.documentsScreen.DocumentsScreen
import com.vzh.docspaceportal.presentation.screens.profileScreen.ProfileScreen
import com.vzh.docspaceportal.presentation.screens.roomsScreen.RoomsScreen
import com.vzh.docspaceportal.presentation.screens.trashScreen.TrashScreen

fun NavGraphBuilder.mainNavGraph(navController: NavController) {
    navigation(startDestination = AppRoute.Documents.route, route = AppRoute.Main.route) {
        composable(AppRoute.Documents.route) {
            Scaffold(
                bottomBar = { BottomNavigationBar(navController) }
            ) { innerPadding->
                DocumentsScreen(
                    modifier = Modifier.padding(innerPadding),
                    navController = navController
                )
            }
        }

        composable(AppRoute.Rooms.route) {
            Scaffold(
                bottomBar = { BottomNavigationBar(navController) }
            ) { innerPadding->
                RoomsScreen(
                    modifier = Modifier.padding(innerPadding),
                    navController = navController
                )
            }
        }

        composable(AppRoute.Trash.route) {
            Scaffold(
                bottomBar = { BottomNavigationBar(navController) }
            ) { innerPadding->
                TrashScreen(
                    modifier = Modifier.padding(innerPadding),
                    navController = navController
                )
            }
        }

        composable(AppRoute.Profile.route) {
            Scaffold(
                bottomBar = { BottomNavigationBar(navController) }
            ) { innerPadding->
                ProfileScreen(
                    modifier = Modifier.padding(innerPadding),
                    navController = navController
                )
            }
        }
    }
}