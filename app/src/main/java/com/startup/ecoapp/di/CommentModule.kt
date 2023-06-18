package com.startup.ecoapp.di

import com.startup.ecoapp.core.network.createRetrofitService
import com.startup.shared.comment.data.api.CommentApi
import com.startup.shared.comment.data.repository.CommentRepositoryImpl
import com.startup.shared.comment.domain.repository.CommentRepository
import com.startup.shared.comment.domain.usecase.CreateCommentUseCase
import com.startup.shared.comment.domain.usecase.GetPostCommentsUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

val commentModule = module {

	single { GetPostCommentsUseCase(get()) }
	single { CreateCommentUseCase(get()) }

	factory<CommentRepository> { CommentRepositoryImpl(get()) }

	single { createRetrofitService<CommentApi>(get(named(ORIGINAL))) }
}