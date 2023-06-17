package com.startup.shared.post.data.mapper

import com.startup.shared.post.data.dto.CategoryDto
import com.startup.shared.post.data.dto.CommentDto
import com.startup.shared.post.data.dto.PostDto
import com.startup.shared.post.domain.entity.Category
import com.startup.shared.post.domain.entity.Comment
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

internal fun CommentDto.toEntity() = Comment(
    comment_id = comment_id,
    comment_text = comment_text,
    count_dislikes = count_dislikes ?: 0,
    count_likes = count_likes ?: 0,
    created = created ?: "",
    edited = edited ?: "",
    post_id = post_id,
    thread_id = chat_id ?: "",
    total_count = total_count ?: 0,
    user_first_name = user_first_name,
    user_id = user_id,
    user_last_name = user_last_name
)

internal fun CategoryDto.toEntity() = Category(
    id = id,
    name = name
)