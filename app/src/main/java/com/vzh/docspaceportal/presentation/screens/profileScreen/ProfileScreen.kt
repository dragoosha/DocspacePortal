package com.vzh.docspaceportal.presentation.screens.profileScreen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.vzh.docspaceportal.R
import com.vzh.docspaceportal.presentation.common.components.CustomButton
import com.vzh.docspaceportal.presentation.common.components.LoadingIndicator
import com.vzh.docspaceportal.presentation.common.components.NoInternetStub
import com.vzh.docspaceportal.presentation.common.navigation.AppRoute
import com.vzh.docspaceportal.presentation.common.utils.hasNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {


    val context = LocalContext.current
    var isInternetAvailable by rememberSaveable { mutableStateOf(true) }
    var isLoading by rememberSaveable { mutableStateOf(true) }


    LaunchedEffect(context) {
        delay(2000)
        isInternetAvailable = context.hasNetwork()
        isLoading = false
    }

    if (isLoading) {
        LoadingIndicator()
        return
    }

    if (!isInternetAvailable) {
        NoInternetStub(
            onRetryClicked = {
                isLoading = true
                isInternetAvailable = context.hasNetwork()
                isLoading = false
            }
        )
        return
    }else {
        val viewModel: ProfileScreenViewModel = koinViewModel()
        val state: ProfileUiState = viewModel.profileUiState.collectAsState().value

        ProfileLayout(
            state = state.uiItem,
            onButtonClicked = {
                if (context.hasNetwork()) {
                    viewModel.logOut()
                    navController.navigate(AppRoute.Auth.route) {
                        popUpTo(AppRoute.Profile.route) {inclusive = true}
                    }
                } else {
                    isInternetAvailable = false
                }

            }
        )

    }
}

@Composable
fun ProfileLayout(
    modifier: Modifier = Modifier,
    state: ProfileUiItem,
    onButtonClicked: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = modifier.height(100.dp))

        Text(
            text = stringResource(R.string.profile),
            style= MaterialTheme.typography.headlineMedium,
            modifier = modifier.align(Alignment.Start)
        )


        Spacer(modifier = modifier.height(50.dp))

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(state.imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = null,
            modifier = Modifier.size(100.dp).clip(CircleShape),
            contentScale = ContentScale.Crop,
        )


        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = state.name,
            style = MaterialTheme.typography.titleLarge,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(R.string.email),
            style = MaterialTheme.typography.bodyMedium
        )

        Text(
            text = state.email,
            style = MaterialTheme.typography.bodyMedium,
        )

        Spacer(modifier = Modifier.height(32.dp))

        CustomButton(
            modifier = modifier,
            onButtonClicked = onButtonClicked,
            text = R.string.logout
        )

    }
}
