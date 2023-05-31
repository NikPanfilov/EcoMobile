package com.startup.ecoapp.core.network.token.data.repository

import com.startup.network.token.data.storage.TokenDataStorage
import com.startup.network.token.domain.model.AuthTokenPair
import com.startup.network.token.domain.repository.TokenRepository

class TokenRepositoryImpl(
	private val storage: TokenDataStorage
) : TokenRepository {

	override fun save(authTokenPair: AuthTokenPair) = storage.save(authTokenPair)

	override fun load() = storage.load()
}