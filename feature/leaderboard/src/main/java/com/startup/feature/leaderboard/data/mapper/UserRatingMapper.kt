package com.startup.feature.leaderboard.data.mapper

import com.startup.feature.leaderboard.data.dto.UserAvatarDto
import com.startup.feature.leaderboard.data.dto.UserRatingDto
import com.startup.feature.leaderboard.domain.entity.UserAvatar
import com.startup.feature.leaderboard.domain.entity.UserRating

internal fun UserRatingDto.toEntity() = UserRating(
	userId = userId,
	firstName = userFirstName,
	lastName = userLastName,
	totalCount = totalCount,
	userAvatar = userAvatar.map { it.toEntity() }
)

internal fun UserAvatarDto.toEntity() = UserAvatar(
	photoPlaceId = photoPlaceId,
	photoId = photoId,
	userId = userId,
	photoPath = photoPath
)