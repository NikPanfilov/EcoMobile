package com.startup.feature.leaderboard.domain.repository

import com.startup.feature.leaderboard.domain.entity.UserRating

interface RatingRepository {

	suspend fun get(page: String): List<UserRating>
}