package com.startup.ecoapp.di

import com.startup.ecoapp.core.network.createRetrofitService
import com.startup.feature.blog.data.api.BlogApi
import com.startup.feature.blog.data.repository.BlogRepositoryImpl
import com.startup.feature.blog.domain.repository.BlogRepository
import com.startup.feature.blog.domain.usecase.DeleteBlogUseCase
import com.startup.feature.blog.domain.usecase.EditBlogUseCase
import com.startup.feature.blog.domain.usecase.GetBlogUseCase
import com.startup.feature.blog.presentation.BlogViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val blogModule = module {
	viewModel {
		BlogViewModel(
			getBlogUseCase = get(),
			editBlogUseCase = get(),
			deleteBlogUseCase = get(),
			getUserIdUseCase = get(),
		)
	}

	factory { createRetrofitService<BlogApi>(get(named(ORIGINAL))) }

	single<BlogRepository> { BlogRepositoryImpl(get()) }

	single { GetBlogUseCase(get()) }
	single { EditBlogUseCase(get()) }
	single { DeleteBlogUseCase(get()) }
}