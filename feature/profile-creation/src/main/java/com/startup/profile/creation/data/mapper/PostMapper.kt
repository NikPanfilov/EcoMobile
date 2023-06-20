package com.startup.profile.creation.data.mapper

import com.startup.profile.creation.data.dto.PostChangesDto
import com.startup.profile.creation.data.dto.PostDto
import com.startup.profile.creation.domain.entity.Post
import com.startup.profile.creation.domain.entity.PostChanges

internal fun Post.toDto() = PostDto(
	blogId = blogId,
	title = title,
	text = text
)

internal fun PostChanges.toDto() = PostChangesDto(
	title = title,
	text = text
)