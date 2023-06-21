package com.startup.ecoapp.di

import com.startup.ecoapp.core.network.createRetrofitService
import com.startup.shared.thread.data.api.ThreadApi
import com.startup.shared.thread.data.repository.ThreadRepositoryImpl
import com.startup.shared.thread.domain.repository.ThreadRepository
import com.startup.shared.thread.domain.usecase.CreateThreadUseCase
import com.startup.shared.thread.domain.usecase.DeleteThreadUseCase
import com.startup.shared.thread.domain.usecase.EditThreadUseCase
import com.startup.shared.thread.domain.usecase.GetAllThreadsUseCase
import com.startup.shared.thread.domain.usecase.GetThreadUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

val threadModule = module {
	factory { createRetrofitService<ThreadApi>(get(named(ORIGINAL))) }

	single<ThreadRepository> { ThreadRepositoryImpl(get()) }

	single { CreateThreadUseCase(get()) }
	single { DeleteThreadUseCase(get()) }
	single { EditThreadUseCase(get()) }
	single { GetAllThreadsUseCase(get()) }
	single { GetThreadUseCase(get()) }
}