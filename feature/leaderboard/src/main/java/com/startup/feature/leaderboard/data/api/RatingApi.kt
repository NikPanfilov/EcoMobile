package com.startup.feature.leaderboard.data.api

import com.startup.feature.leaderboard.data.dto.ResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface RatingApi {

	@GET("api/ratings/users")
	suspend fun get(@Query("page") page: String): ResponseDto
}