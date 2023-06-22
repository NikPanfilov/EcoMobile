package com.startup.feature.leaderboard.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResponseDto(
	@Json(name = "users_ratings") val userRatings: List<UserRatingDto>
)

@JsonClass(generateAdapter = true)
data class UserRatingDto(
	@Json(name = "user_id") val userId: String,
	@Json(name = "user_first_name") val userFirstName: String,
	@Json(name = "user_last_name") val userLastName: String,
	@Json(name = "total_count") val totalCount: Int,
	@Json(name = "user_avatar") val userAvatar: List<UserAvatarDto>
)

@JsonClass(generateAdapter = true)
data class UserAvatarDto(
	@Json(name = "photo_place_id") val photoPlaceId: String,
	@Json(name = "photo_id") val photoId: String,
	@Json(name = "user_id") val userId: String,
	@Json(name = "photo_path") val photoPath: String
)
