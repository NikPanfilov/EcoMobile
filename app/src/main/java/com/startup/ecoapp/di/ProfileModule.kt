package com.startup.ecoapp.di

import com.startup.ecoapp.core.network.createRetrofitService
import com.startup.feature.profile.data.api.ProfileApi
import com.startup.feature.profile.data.repository.ProfileRepositoryImpl
import com.startup.feature.profile.domain.repository.ProfileRepository
import com.startup.feature.profile.domain.usecase.ChangeProfileUseCase
import com.startup.feature.profile.domain.usecase.GetProfileUseCase
import com.startup.feature.profile.presentation.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val profileModule = module {
	viewModel {
		ProfileViewModel(
			getProfileUseCase = get(),
			changeProfileUseCase = get(),
		)
	}
	factory { createRetrofitService<ProfileApi>(get(named(ORIGINAL))) }

	single<ProfileRepository> { ProfileRepositoryImpl(get()) }

	single { GetProfileUseCase(get()) }
	single { ChangeProfileUseCase(get()) }
}