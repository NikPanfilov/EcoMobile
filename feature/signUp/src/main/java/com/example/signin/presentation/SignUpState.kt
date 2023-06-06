package com.example.signin.presentation

data class SignUpState
    (
    val firstName: String = "",
    val lastName: String = "",
    val birthDate: String = "",
    val city: String = "",
    val phone: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val isLoading: Boolean = false,
    val error: String? = null
)