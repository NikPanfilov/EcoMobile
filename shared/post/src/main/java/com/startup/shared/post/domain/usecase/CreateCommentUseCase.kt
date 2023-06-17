package com.startup.shared.post.domain.usecase

import com.startup.shared.post.domain.repository.PostRepository

class CreateCommentUseCase(val repository: PostRepository) {
    suspend operator fun invoke(
        userId: String,
        postId: String,
        commentText: String
    ) = repository.createComment(
        userId = userId,
        postId = postId,
        commentText = commentText
    )
}