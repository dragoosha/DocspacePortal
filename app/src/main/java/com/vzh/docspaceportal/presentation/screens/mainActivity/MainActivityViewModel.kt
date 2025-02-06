package com.vzh.docspaceportal.presentation.screens.mainActivity

import androidx.datastore.core.DataStore
import androidx.lifecycle.ViewModel
import com.vzh.docspaceportal.presentation.common.utils.UserSettings
import kotlinx.coroutines.flow.map

class MainActivityViewModel(
    private val dataStore: DataStore<UserSettings>
): ViewModel() {
    val authState = dataStore.data.map { it.token }
}