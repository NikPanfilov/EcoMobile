package com.startup.ecoapp.core.network.token.domain.usecase

import com.startup.network.token.domain.model.AuthTokenPair
import com.startup.network.token.domain.repository.TokenRepository

class SaveTokenUseCase(
	private val repository: TokenRepository,
) {

	operator fun invoke(authTokenPair: AuthTokenPair) = repository.save(authTokenPair)
}