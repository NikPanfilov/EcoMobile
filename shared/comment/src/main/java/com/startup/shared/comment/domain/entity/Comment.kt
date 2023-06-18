package com.startup.shared.comment.domain.entity

data class Comment(
	val commentId: String,
	val userId: String,
	val postId: String?,
	val threadId: String?,
	val commentText: String,
	val dislikesCount: Int,
	val likesCount: Int,
	val created: String,
	val edited: String,
	val totalCount: Int,
	val userFirstName: String,
	val userLastName: String
)