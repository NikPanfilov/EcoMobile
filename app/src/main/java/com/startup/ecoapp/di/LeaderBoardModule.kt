package com.startup.ecoapp.di

import com.startup.ecoapp.core.network.createRetrofitService
import com.startup.feature.leaderboard.data.api.RatingApi
import com.startup.feature.leaderboard.data.repository.RatingRepositoryImpl
import com.startup.feature.leaderboard.domain.repository.RatingRepository
import com.startup.feature.leaderboard.domain.usecase.GetUserRatingUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

val leaderboardModule = module {

	factory { createRetrofitService<RatingApi>(get(named(ORIGINAL))) }

	single<RatingRepository> { RatingRepositoryImpl(get()) }

	single { GetUserRatingUseCase(get()) }
}