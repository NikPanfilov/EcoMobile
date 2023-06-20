package com.startup.feature.blog.domain.entity

data class Blog(
	val blogId: String,
	val userId: String,
	val authorFirstName: String,
	val authorLastName: String,
	val title: String,
	val description: String,
	val avatar: String
)
