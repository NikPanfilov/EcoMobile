package com.startup.ecoapp.di

import com.startup.ecoapp.core.network.createRetrofitService
import com.startup.shared.events.data.api.EventsApi
import com.startup.shared.events.data.repository.EventsRepositoryImpl
import com.startup.shared.events.domain.repository.EventsRepository
import com.startup.shared.events.domain.usecase.CreateEventUseCase
import com.startup.shared.events.domain.usecase.DeleteEventUseCase
import com.startup.shared.events.domain.usecase.EditEventUseCase
import com.startup.shared.events.domain.usecase.GetEventUseCase
import com.startup.shared.events.domain.usecase.GetEventsUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

val eventsModule = module {
	factory { createRetrofitService<EventsApi>(get(named(ORIGINAL))) }

	single<EventsRepository> { EventsRepositoryImpl(get()) }

	single { CreateEventUseCase(get()) }
	single { DeleteEventUseCase(get()) }
	single { EditEventUseCase(get()) }
	single { GetEventsUseCase(get()) }
	single { GetEventUseCase(get()) }
}