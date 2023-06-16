package com.startup.shared.post.domain.usecase

import com.startup.shared.post.data.PostsDataSource
import com.startup.shared.post.domain.repository.PostRepository

class GetPostsUseCase(private val repository: PostRepository) {

    operator fun invoke(filter: String) =
        PostsDataSource(repository)
}