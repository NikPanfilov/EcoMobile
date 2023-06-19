package com.startup.ecoapp.di

import com.startup.ecoapp.core.network.createRetrofitService
import com.startup.shared.post.data.api.PostApi
import com.startup.shared.post.data.repository.PostRepositoryImpl
import com.startup.shared.post.domain.repository.PostRepository
import com.startup.shared.post.domain.usecase.GetBlogPostsUseCase
import com.startup.shared.post.domain.usecase.GetPostByIdUseCase
import com.startup.shared.post.domain.usecase.GetPostsUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

val postModule = module {
	factory { createRetrofitService<PostApi>(get(named(ORIGINAL))) }

	single<PostRepository> { PostRepositoryImpl(get()) }

	single { GetPostByIdUseCase(get()) }
	single { GetPostsUseCase(get()) }
	single { GetBlogPostsUseCase(get()) }
}