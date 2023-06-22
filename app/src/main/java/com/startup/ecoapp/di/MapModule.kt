package com.startup.ecoapp.di

import com.startup.ecoapp.core.network.createRetrofitService
import com.startup.feature.map.data.api.MarkerApi
import com.startup.feature.map.data.repository.MarkerRepositoryImpl
import com.startup.feature.map.domain.repository.MarkerRepository
import com.startup.feature.map.domain.usecase.GetMarkersUseCase
import com.startup.feature.map.presentation.MapViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val mapModule = module {
	viewModel {
		MapViewModel(
			getMarkersUseCase = get()
		)
	}

	factory { createRetrofitService<MarkerApi>(get(named(ORIGINAL))) }

	single<MarkerRepository> { MarkerRepositoryImpl(get()) }

	single { GetMarkersUseCase(get()) }
}