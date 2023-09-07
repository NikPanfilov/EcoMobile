package com.startup.ecoapp.di

import com.startup.ecoapp.core.network.createRetrofitService
import com.startup.shared.reactions.data.api.ReactionApi
import com.startup.shared.reactions.data.repository.ReactionRepositoryImpl
import com.startup.shared.reactions.domain.repository.ReactionRepository
import com.startup.shared.reactions.domain.usecase.CancelVoteUseCase
import com.startup.shared.reactions.domain.usecase.DownVoteUseCase
import com.startup.shared.reactions.domain.usecase.UpVoteUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

val reactionsModule = module {
	factory { createRetrofitService<ReactionApi>(get(named(ORIGINAL))) }

	single<ReactionRepository> { ReactionRepositoryImpl(get()) }

	single { CancelVoteUseCase(get()) }
	single { DownVoteUseCase(get()) }
	single { UpVoteUseCase(get()) }
}