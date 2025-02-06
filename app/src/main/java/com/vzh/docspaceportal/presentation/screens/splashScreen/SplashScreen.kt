package com.vzh.docspaceportal.presentation.screens.splashScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.vzh.docspaceportal.R
import com.vzh.docspaceportal.presentation.common.navigation.AppRoute
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController,
    token: String?
) {
    LaunchedEffect(key1 = token) {
        delay(1000)
        if (token.isNullOrEmpty()) {
            navController.navigate(AppRoute.Auth.route) {
                popUpTo(AppRoute.Splash.route) { inclusive = true }
            }
        } else {
            navController.navigate(AppRoute.Main.route) {
                popUpTo(AppRoute.Splash.route) { inclusive = true }
            }
        }
    }

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.logo_symbol),
            contentDescription = null
        )
        
        Spacer(modifier = Modifier.height(40.dp))
        CircularProgressIndicator()
    }
}
