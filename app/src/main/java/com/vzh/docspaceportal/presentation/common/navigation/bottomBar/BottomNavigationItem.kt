package com.vzh.docspaceportal.presentation.common.navigation.bottomBar

import androidx.compose.ui.graphics.painter.Painter

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: Painter,
    val unselectedIcon: Painter,
    val route: String
)
