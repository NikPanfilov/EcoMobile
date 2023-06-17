package com.startup.shared.post.data.repository

import com.startup.shared.post.data.api.PostApi
import com.startup.shared.post.data.mapper.toEntity
import com.startup.shared.post.domain.entity.Comment
import com.startup.shared.post.domain.entity.Post
import com.startup.shared.post.domain.repository.PostRepository

class PostRepositoryImpl(private val api: PostApi) : PostRepository {

    override suspend fun getPosts(filter: String, page: String): List<Post> =
        api.getPosts(filter = filter, page = page).posts.map { it.toEntity() }

    override suspend fun getPost(id: String): Post = api.getPost(id = id).toEntity()

    override suspend fun getComments(id: String, filter: String, page: String): List<Comment> =
        api.getComments(id = id, filter = filter, page = page).comments.map { it.toEntity() }

    override suspend fun createComment(userId: String, postId: String, commentText: String) {
        api.createComment(userId = userId, postId = postId, commentText = commentText)
    }
}