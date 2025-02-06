package com.vzh.docspaceportal.presentation.screens.profileScreen

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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.vzh.docspaceportal.R
import com.vzh.docspaceportal.presentation.common.components.CustomButton
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    val viewModel: ProfileScreenViewModel = koinViewModel()
    val state: ProfileUiState = viewModel.profileUiState.collectAsState().value

    ProfileLayout(
        modifier = modifier,
        state = state.uiItem,
        onButtonClicked = {}
    )

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


        Box(modifier = modifier.size(100.dp).background(color = Color.Gray).clip(shape = RoundedCornerShape(20.dp))){
            AsyncImage(
                model = state.imageUrl,
                contentDescription = null,
                modifier = modifier.size(100.dp).clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        }


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
