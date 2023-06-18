package com.startup.shared.post.data.mapper

import com.startup.shared.post.data.dto.CategoryDto
import com.startup.shared.post.data.dto.PostDto
import com.startup.shared.post.domain.entity.Category
import com.startup.shared.post.domain.entity.Post

internal fun PostDto.toEntity() = Post(
	id = postId,
	title = postTitle,
	text = postText,
	blogId = blogId,
	blogTitle = blogTitle,
	//authorAvatar = authorAvatar,
	authorFirstName = authorFirstName,
	authorLastName = authorLastName,
	categories = categories.map { it.toEntity() },
	photos = photos,
	created = created ?: "now",
	edited = edited,
	likes = likes,
	dislikes = dislikes
)

internal fun CategoryDto.toEntity() = Category(
	id = id,
	name = name
)