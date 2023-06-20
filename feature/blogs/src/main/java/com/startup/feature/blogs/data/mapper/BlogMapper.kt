package com.startup.feature.blogs.data.mapper

import com.startup.feature.blogs.data.dto.BlogDto
import com.startup.feature.blogs.domain.entity.Blog

internal fun BlogDto.toEntity() = Blog(
	blogId = blogId,
	userId = userId,
	authorFirstName = authorFirstName,
	authorLastName = authorLastName,
	title = title,
	description = description,
	avatar = avatar
)