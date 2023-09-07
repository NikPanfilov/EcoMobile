package com.startup.ecoapp.core.network.token.domain.usecase

import android.util.Base64
import com.startup.ecoapp.core.network.token.domain.repository.TokenRepository
import org.json.JSONObject

class GetUserIdUseCase(
	private val repository: TokenRepository,
) {

	operator fun invoke(): String {
		val token = repository.load().accessToken
		val encodedPayload = token.split(".")[1]
		val payloadJson = Base64.decode(encodedPayload, Base64.DEFAULT).toString(Charsets.UTF_8)
		val payloadObject = JSONObject(payloadJson)

		return payloadObject.getString("user_id")
	}
}