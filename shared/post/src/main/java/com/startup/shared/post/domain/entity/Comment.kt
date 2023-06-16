package com.startup.shared.post.domain.entity

data class Comment(
    val comment_id: String,
    val comment_text: String,
    val count_dislikes: Int,
    val count_likes: Int,
    val created: String,
    val edited: String,
    val post_id: String,
    val thread_id: String,
    val total_count: Int,
    val user_first_name: String,
    val user_id: String,
    val user_last_name: String
)