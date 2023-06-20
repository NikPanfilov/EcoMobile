package com.startup.ecoapp.di

import com.startup.ecoapp.core.network.createRetrofitService
import com.startup.profile.creation.data.api.PostCreationApi
import com.startup.profile.creation.data.repository.PostCreationRepositoryImpl
import com.startup.profile.creation.domain.repository.PostCreationRepository
import com.startup.profile.creation.domain.usecase.CreatePostUseCase
import com.startup.profile.creation.domain.usecase.DeletePostUseCase
import com.startup.profile.creation.domain.usecase.EditPostUseCase
import com.startup.profile.creation.presentation.ProfileCreationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val profileChangesModule = module {
	viewModel {
		ProfileCreationViewModel(
			createPostUseCase = get(),
			editPostUseCase = get(),
			deletePostUseCase = get()
		)
	}

	factory { createRetrofitService<PostCreationApi>(get(named(ORIGINAL))) }

	single<PostCreationRepository> { PostCreationRepositoryImpl(get()) }

	single { CreatePostUseCase(get()) }
	single { EditPostUseCase(get()) }
	single { DeletePostUseCase(get()) }
}