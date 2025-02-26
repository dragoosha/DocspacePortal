package com.vzh.docspaceportal.presentation.screens.loginScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.vzh.docspaceportal.R
import com.vzh.docspaceportal.presentation.common.components.CustomButton
import com.vzh.docspaceportal.presentation.common.components.CustomEditText
import com.vzh.docspaceportal.presentation.common.components.LoadingIndicator
import com.vzh.docspaceportal.presentation.common.components.NoInternetStub
import com.vzh.docspaceportal.presentation.common.navigation.AppRoute
import com.vzh.docspaceportal.presentation.common.utils.hasNetwork
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val viewModel: LoginScreenViewModel = koinViewModel()
    val state = viewModel.loginState.collectAsState().value
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
    }

    LoginLayout(
        modifier = modifier,
        state = state.uiItem,
        controller = viewModel,
        onButtonLoginClicked = {
            if (context.hasNetwork()) {
                viewModel.validateAndLogin(context)
            } else {
                isInternetAvailable = false
            }
        },
        errorMessage = state.authErrorMessage
    )

    LaunchedEffect(key1 = state.authenticationSucceed) {
        if (state.authenticationSucceed) {
            navController.navigate(AppRoute.Documents.route) {
                popUpTo(AppRoute.Auth.route) { inclusive = true }
            }
        }
    }
}


@Composable
fun LoginLayout(
    modifier: Modifier = Modifier,
    state: LoginUiItem,
    controller: LoginScreenViewModel,
    onButtonLoginClicked: () -> Unit,
    errorMessage: String? = null
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.connect_text),
            style = MaterialTheme.typography.titleLarge,
            maxLines = 1
        )

        if (errorMessage != null) {
            Text(
                text = errorMessage,
                color = Color.Red,
                style = MaterialTheme.typography.bodySmall
            )
        }

        Spacer(modifier = modifier.height(20.dp))

        CustomEditText(
            modifier = modifier.clip(shape = RoundedCornerShape(20.dp)),
            value = state.portal,
            onValueChange = { controller.updatePortal(it) },
            hint = R.string.portal,
            icon = R.drawable.ic_launcher_foreground
        )
        if (state.portalError != null) {
            Text(
                text = state.portalError,
                color = Color.Red,
                style = MaterialTheme.typography.bodySmall
            )
        }

        Spacer(modifier = modifier.height(20.dp))

        CustomEditText(
            modifier = modifier.clip(shape = RoundedCornerShape(20.dp)),
            value = state.email,
            onValueChange = { controller.updateEmail(it) },
            hint = R.string.email,
            icon = R.drawable.ic_launcher_foreground
        )
        if (state.emailError != null) {
            Text(
                text = state.emailError,
                color = Color.Red,
                style = MaterialTheme.typography.bodySmall
            )
        }

        Spacer(modifier = modifier.height(20.dp))

        CustomEditText(
            modifier = modifier.clip(shape = RoundedCornerShape(20.dp)),
            value = state.password,
            onValueChange = { controller.updatePassword(it) },
            hint = R.string.password,
            icon = R.drawable.ic_launcher_foreground
        )
        if (state.passwordError != null) {
            Text(
                text = state.passwordError,
                color = Color.Red,
                style = MaterialTheme.typography.bodySmall
            )
        }

        Spacer(modifier = modifier.height(20.dp))

        CustomButton(
            onButtonClicked = onButtonLoginClicked,
            text = R.string.login
        )
    }
}