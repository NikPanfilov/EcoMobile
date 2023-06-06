package com.startup.ecoapp.di

import com.startup.ecoapp.core.network.createRetrofitService
import com.startup.ecoapp.signup.data.api.SignUpApi
import com.startup.ecoapp.signup.data.repository.SignUpRepositoryImpl
import com.startup.ecoapp.signup.domain.repository.SignUpRepository
import com.startup.ecoapp.signup.domain.usecase.SignUpUseCase
import com.startup.ecoapp.signup.presentation.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val signUpModule = module {
	viewModel {
		SignUpViewModel(
			signUpUseClass = get(),
			saveTokenUseCase = get()
		)
	}

	factory { createRetrofitService<SignUpApi>(get(named(ORIGINAL))) }

	single<SignUpRepository> { SignUpRepositoryImpl(get()) }

	single { SignUpUseCase(get()) }
}