package com.startup.shared.post.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CommentsResponseDto(
    @Json(name = "comments_ratings") val comments: List<CommentDto>
)

@JsonClass(generateAdapter = true)
data class CommentDto(
    @Json val comment_id: String,
    @Json val comment_text: String,
    @Json val count_dislikes: Int?,
    @Json val count_likes: Int?,
    @Json val created: String?,
    @Json val edited: String?,
    @Json val post_id: String,
    @Json val chat_id: String?,
    @Json val total_count: Int?,
    @Json val user_first_name: String,
    @Json val user_id: String,
    @Json val user_last_name: String
)