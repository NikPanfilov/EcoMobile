package com.startup.shared.post.domain.usecase

import com.startup.shared.post.data.CommentsDataSource
import com.startup.shared.post.domain.repository.PostRepository

class GetCommentsUseCase(private val repository: PostRepository) {

    operator fun invoke(filter: String = "", id: String) =
        CommentsDataSource(repo = repository, filter = filter, id = id)
}