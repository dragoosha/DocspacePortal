package com.vzh.docspaceportal.di

import androidx.datastore.core.DataStoreFactory
import com.vzh.docspaceportal.data.remote.ApiService
import com.vzh.docspaceportal.data.repos.ApiServiceRepoImpl
import com.vzh.docspaceportal.domain.repos.ApiServiceRepo
import com.vzh.docspaceportal.domain.usecase.AuthUseCase
import com.vzh.docspaceportal.domain.usecase.GetFileByIdUseCase
import com.vzh.docspaceportal.domain.usecase.GetProfileUseCase
import com.vzh.docspaceportal.domain.usecase.GetRoomsUseCase
import com.vzh.docspaceportal.domain.usecase.GetTrashUseCase
import com.vzh.docspaceportal.domain.usecase.LogOutUseCase
import com.vzh.docspaceportal.domain.usecase.MyDocumentsUseCase
import com.vzh.docspaceportal.presentation.common.utils.UserSettingsSerializer
import com.vzh.docspaceportal.presentation.screens.documentsScreen.DocumentsScreenViewModel
import com.vzh.docspaceportal.presentation.screens.folderScreen.FolderScreen
import com.vzh.docspaceportal.presentation.screens.folderScreen.FolderScreenViewModel
import com.vzh.docspaceportal.presentation.screens.loginScreen.LoginScreenViewModel
import com.vzh.docspaceportal.presentation.screens.mainActivity.MainActivityViewModel
import com.vzh.docspaceportal.presentation.screens.profileScreen.ProfileScreenViewModel
import com.vzh.docspaceportal.presentation.screens.roomsScreen.RoomsScreenViewModel
import com.vzh.docspaceportal.presentation.screens.trashScreen.TrashScreenViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("http://localhost/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    single<ApiServiceRepo> { ApiServiceRepoImpl(get()) }

    factory { AuthUseCase() }
    factory { MyDocumentsUseCase() }
    factory { GetFileByIdUseCase() }
    factory { GetProfileUseCase() }
    factory { GetRoomsUseCase() }
    factory { GetTrashUseCase() }
    factory { LogOutUseCase() }
}

val appModule = module {
    viewModel { LoginScreenViewModel(get(), get()) }
    viewModel { MainActivityViewModel(get()) }
    viewModel { DocumentsScreenViewModel(get(), get()) }
    viewModel { RoomsScreenViewModel(get(), get()) }
    viewModel { TrashScreenViewModel(get(), get()) }
    viewModel { ProfileScreenViewModel(get(), get(), get()) }
    viewModel { FolderScreenViewModel(get(), get()) }

    single {
        DataStoreFactory.create(
            serializer = UserSettingsSerializer,
            produceFile = { File(androidContext().filesDir, "app_user_settings") }
        )
    }
}