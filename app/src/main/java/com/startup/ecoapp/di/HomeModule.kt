package com.startup.ecoapp.di

import com.startup.ecoapp.feature.home.presentation.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
	viewModel {
		HomeViewModel(
			getPostsUseCase = get(),
			getUserIdUseCase = get(),
			cancelVoteUseCase = get(),
			downVoteUseCase = get(),
			upVoteUseCase = get()
		)
	}
}