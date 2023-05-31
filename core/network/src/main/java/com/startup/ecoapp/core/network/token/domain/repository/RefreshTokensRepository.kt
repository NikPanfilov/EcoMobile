package com.startup.ecoapp.core.network.token.domain.repository

import com.startup.network.token.domain.model.AuthTokenPair

interface RefreshTokensRepository {

	suspend fun refreshTokens(): AuthTokenPair
}