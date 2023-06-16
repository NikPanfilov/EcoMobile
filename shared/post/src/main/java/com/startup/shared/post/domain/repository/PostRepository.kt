package com.startup.shared.post.domain.repository

import com.startup.shared.post.domain.entity.Comment
import com.startup.shared.post.domain.entity.Post

interface PostRepository {

    suspend fun getPosts(filter: String, page: String): List<Post>

    suspend fun getPost(id: String): Post

    suspend fun getComments(id: String, filter: String, page: String): List<Comment>
}