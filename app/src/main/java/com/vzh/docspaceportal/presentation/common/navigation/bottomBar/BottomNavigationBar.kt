package com.vzh.docspaceportal.presentation.common.navigation.bottomBar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.vzh.docspaceportal.R
import com.vzh.docspaceportal.presentation.common.theme.DocspacePortalTheme

@Composable
fun BottomNavigationBar(navController: NavController) {
    var selectedItemIndex by rememberSaveable { mutableStateOf(0) }

    val items = listOf(
        BottomNavigationItem(
            stringResource(R.string.documents),
            painterResource(R.drawable.baseline_circle_24),
            painterResource(R.drawable.outline_crop_square_24),
            "main/documents"
        ),
        BottomNavigationItem(
            stringResource(R.string.rooms),
            painterResource(R.drawable.baseline_circle_24),
            painterResource(R.drawable.outline_crop_square_24),
            "main/rooms"
        ),
        BottomNavigationItem(
            stringResource(R.string.trash),
            painterResource(R.drawable.baseline_circle_24),
            painterResource(R.drawable.outline_crop_square_24),
            "main/trash"
        ),
        BottomNavigationItem(
            stringResource(R.string.profile),
            painterResource(R.drawable.baseline_person_24),
            painterResource(R.drawable.baseline_person_24),
            "main/profile"
        )
    )

    selectedItemIndex = items.indexOfFirst { it.route == navController.currentDestination?.route }

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = {
                    if (selectedItemIndex != index) {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = {
                    Image(
                        painter = if (selectedItemIndex == index) {
                            item.selectedIcon
                        } else {
                            item.unselectedIcon
                        },
                        contentDescription = item.title,
                        modifier = Modifier.size(20.dp)
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        style = MaterialTheme.typography.titleSmall
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent,

                    )
            )
        }
    }


}

@Preview(showBackground = true)
@Composable
private fun Prev() {
    DocspacePortalTheme {
        BottomNavigationBar(rememberNavController())
    }
}