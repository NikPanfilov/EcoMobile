package com.startup.shared.post.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PostResponseDto(
	@Json(name = "posts") val posts: List<PostDto>
)

@JsonClass(generateAdapter = true)
data class PostDto(
	@Json(name = "post_id") val postId: String,
	@Json(name = "blog_id") val blogId: String,
	@Json(name = "blog_title") val blogTitle: String,
	@Json(name = "user_first_name") val authorFirstName: String,
	@Json(name = "user_last_name") val authorLastName: String,
	//@Json(name = "profile_avatar") val authorAvatar: String,
	@Json(name = "post_title") val postTitle: String,
	@Json(name = "post_text") val postText: String,
	@Json(name = "categories") val categories: List<CategoryDto>,
	@Json(name = "photos") val photos: String?,
	@Json(name = "created") val created: String?,
	@Json(name = "edited") val edited: String?,
	@Json(name = "count_likes") val likes: Int,
	@Json(name = "count_dislikes") val dislikes: Int,
)

@JsonClass(generateAdapter = true)
data class CategoryDto(
	@Json(name = "category_id") val id: String,
	@Json(name = "category_name") val name: String,
)
