package com.startup.ecoapp.feature.home.presentation

data class HomeState(
	val isLoading: Boolean = false,
	val error: String? = null,
)
