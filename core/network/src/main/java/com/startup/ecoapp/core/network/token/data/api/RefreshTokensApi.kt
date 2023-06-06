package com.startup.ecoapp.core.network.token.data.api

import com.startup.ecoapp.core.network.token.data.dto.AuthTokenPairDto
import retrofit2.http.POST

interface RefreshTokensApi {

	@POST("api/auth/refresh")
	suspend fun refresh(): AuthTokenPairDto
}