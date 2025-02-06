package com.vzh.docspaceportal.presentation.screens.mainActivity

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.vzh.docspaceportal.presentation.common.navigation.AppNavigation
import com.vzh.docspaceportal.presentation.common.theme.DocspacePortalTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val viewModel: MainActivityViewModel by viewModel()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DocspacePortalTheme {
                val token = viewModel.authState.collectAsStateWithLifecycle(initialValue = null)
                AppNavigation(token = token.value)
            }
        }
    }
}
