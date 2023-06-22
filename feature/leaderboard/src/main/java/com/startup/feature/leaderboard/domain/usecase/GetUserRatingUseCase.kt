package com.startup.feature.leaderboard.domain.usecase

import com.startup.feature.leaderboard.domain.entity.UserRating
import com.startup.feature.leaderboard.domain.repository.RatingRepository

class GetUserRatingUseCase(private val repository: RatingRepository) {

	suspend operator fun invoke(page: String): List<UserRating> =
		repository.get(page)
}