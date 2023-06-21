package com.startup.ecoapp.di

import com.startup.ecoapp.core.network.createRetrofitService
import com.startup.post.creation.data.api.PostCreationApi
import com.startup.post.creation.data.repository.PostCreationRepositoryImpl
import com.startup.post.creation.domain.repository.PostCreationRepository
import com.startup.post.creation.domain.usecase.AddCategoryUseCase
import com.startup.post.creation.domain.usecase.CreatePostUseCase
import com.startup.post.creation.domain.usecase.DeletePostUseCase
import com.startup.post.creation.domain.usecase.EditPostUseCase
import com.startup.post.creation.presentation.PostCreationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val postChangesModule = module {
	viewModel {
		PostCreationViewModel(
			createPostUseCase = get(),
			editPostUseCase = get(),
			deletePostUseCase = get(),
			createCategoryUseCase = get(),
			getCategoriesUseCase = get(),
			addCategoryUseCase = get()
		)
	}

	factory { createRetrofitService<PostCreationApi>(get(named(ORIGINAL))) }

	single<PostCreationRepository> { PostCreationRepositoryImpl(get()) }

	single { CreatePostUseCase(get()) }
	single { EditPostUseCase(get()) }
	single { DeletePostUseCase(get()) }
	single { AddCategoryUseCase(get()) }
}