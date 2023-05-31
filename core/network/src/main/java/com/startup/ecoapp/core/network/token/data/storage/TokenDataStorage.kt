package com.startup.ecoapp.core.network.token.data.storage

import com.startup.network.token.domain.model.AuthTokenPair

interface TokenDataStorage {

	fun save(authTokenPair: AuthTokenPair)

	fun load(): AuthTokenPair
}