package com.startup.ecoapp.di

import com.startup.ecoapp.core.network.createRetrofitService
import com.startup.feature.blogs.data.api.BlogsApi
import com.startup.feature.blogs.data.repository.BlogsRepositoryImpl
import com.startup.feature.blogs.domain.repository.BlogsRepository
import com.startup.feature.blogs.domain.usecase.CreateBlogUseCase
import com.startup.feature.blogs.domain.usecase.GetBlogsUseCase
import com.startup.feature.blogs.domain.usecase.GetUserBlogsUseCase
import com.startup.feature.blogs.presentation.BlogsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val blogsModule = module {
	viewModel {
		BlogsViewModel(
			getBlogsUseCase = get(),
			getUserBlogsUseCase = get(),
			createBlogUseCase = get(),
			getUserIdUseCase = get(),
		)
	}

	factory { createRetrofitService<BlogsApi>(get(named(ORIGINAL))) }

	single<BlogsRepository> { BlogsRepositoryImpl(get()) }

	single { GetBlogsUseCase(get()) }
	single { GetUserBlogsUseCase(get()) }
	single { CreateBlogUseCase(get()) }
}