package com.vzh.docspaceportal.presentation.screens.loginScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.vzh.docspaceportal.R
import com.vzh.docspaceportal.presentation.common.components.CustomButton
import com.vzh.docspaceportal.presentation.common.components.CustomEditText

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {

}

@Composable
fun LoginLayout(
    modifier: Modifier = Modifier,
    state: LoginUiItem,
    onPortalValueChanged: (String) -> Unit,
    onEmailValueChanged: (String) -> Unit,
    onPasswordValueChanged: (String) -> Unit,
    onButtonLoginClicked: () -> Unit
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

        Spacer(modifier = modifier.height(20.dp))

        CustomEditText(
            modifier = modifier.clip(shape = RoundedCornerShape(20.dp)),
            value = state.portal,
            onValueChange = onPortalValueChanged,
            hint = R.string.portal,
            icon = R.drawable.ic_launcher_foreground
        )

        Spacer(modifier = modifier.height(20.dp))

        CustomEditText(
            modifier = modifier.clip(shape = RoundedCornerShape(20.dp)),
            value = state.email,
            onValueChange = onEmailValueChanged,
            hint = R.string.email,
            icon = R.drawable.ic_launcher_foreground
        )

        Spacer(modifier = modifier.height(20.dp))

        CustomEditText(
            modifier = modifier.clip(shape = RoundedCornerShape(20.dp)),
            value = state.password,
            onValueChange = onPasswordValueChanged,
            hint = R.string.password,
            icon = R.drawable.ic_launcher_foreground
        )

        Spacer(modifier = modifier.height(20.dp))

        CustomButton(
            onButtonClicked = onButtonLoginClicked,
            text = R.string.login
        )

    }
}