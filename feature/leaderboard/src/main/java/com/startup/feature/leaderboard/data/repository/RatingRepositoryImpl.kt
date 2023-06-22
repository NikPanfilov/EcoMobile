package com.startup.feature.leaderboard.data.repository

import com.startup.feature.leaderboard.data.api.RatingApi
import com.startup.feature.leaderboard.data.mapper.toEntity
import com.startup.feature.leaderboard.domain.entity.UserRating
import com.startup.feature.leaderboard.domain.repository.RatingRepository

class RatingRepositoryImpl(private val api: RatingApi) : RatingRepository {

	override suspend fun get(page: String): List<UserRating> =
		api.get(page).userRatings.map { it.toEntity() }
}