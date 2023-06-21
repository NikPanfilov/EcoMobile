package com.startup.ecoapp.di

import com.startup.ecoapp.core.network.createRetrofitService
import com.startup.shared.subscriptions.data.api.SubscriptionsApi
import com.startup.shared.subscriptions.data.repository.SubscriptionsRepositoryImpl
import com.startup.shared.subscriptions.domain.repository.SubscriptionsRepository
import com.startup.shared.subscriptions.domain.usecase.DeleteSubscriptionUseCase
import com.startup.shared.subscriptions.domain.usecase.GetBlogsSubscriptionsUseCase
import com.startup.shared.subscriptions.domain.usecase.GetEventsSubscriptionsUseCase
import com.startup.shared.subscriptions.domain.usecase.SubscribeUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

val subscriptionsModule = module {
	factory { createRetrofitService<SubscriptionsApi>(get(named(ORIGINAL))) }

	single<SubscriptionsRepository> { SubscriptionsRepositoryImpl(get()) }

	single { DeleteSubscriptionUseCase(get()) }
	single { GetBlogsSubscriptionsUseCase(get()) }
	single { GetEventsSubscriptionsUseCase(get()) }
	single { SubscribeUseCase(get()) }
}