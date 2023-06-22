package com.startup.feature.leaderboard.domain.entity

data class UserRating(
	val userId: String,
	val firstName: String,
	val lastName: String,
	val totalCount: Int,
	val userAvatar: List<UserAvatar>
)

data class UserAvatar(
	val photoPlaceId: String,
	val photoId: String,
	val userId: String,
	val photoPath: String
)
