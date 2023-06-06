package com.startup.ecoapp.domain.usecase

import com.startup.ecoapp.domain.models.UserSignInData
import com.startup.ecoapp.domain.repository.AuthorizationRepository

class SignInUseCase(private val repository: AuthorizationRepository) {

	suspend fun execute(userData: UserSignInData) = repository.signIn(userData)

}