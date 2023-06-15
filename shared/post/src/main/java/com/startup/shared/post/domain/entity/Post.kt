package com.startup.shared.post.domain.entity

data class Post(
	val id: String,
	val blogId: String,
	val blogTitle: String,
	val authorId: String,
	val authorFirstName: String,
	val authorLastName: String,
	val authorAvatar: String,
	val title: String,
	val text: String,
	val categories: List<Category>,
	val photos: String?,
	val created: String,
	val edited: String,
	val likes: Int,
	val dislikes: Int,
)

data class Category(
	val id: String,
	val name: String,
)

enum class UserReaction(val type: String) {
	LIKE("like"),
	DISLIKE("dislike"),
	NONE("none")
}