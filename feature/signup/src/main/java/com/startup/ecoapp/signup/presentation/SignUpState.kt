package com.startup.ecoapp.signup.presentation

data class SignUpState(
	val firstName: String = "",
	val lastName: String = "",
	val birthDate: String = "",
	val city: String = "",
	val phone: String = "",
	val email: String = "",
	val password: String = "",
	val isLoading: Boolean = false,
	val error: String? = null
)

