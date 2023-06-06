package com.startup.ecoapp.domain.usecase

import com.startup.ecoapp.domain.models.UserSignUpData
import com.startup.ecoapp.domain.repository.AuthorizationRepository

class SignUpUseCase(private val repository: AuthorizationRepository) {

	suspend fun execute(userData: UserSignUpData) = repository.signUp(userData)

}