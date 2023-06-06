package com.startup.ecoapp.domain.usecase

import com.startup.ecoapp.domain.repository.BlogRepository
import com.startup.ecoapp.domain.repository.FirstStartRepository

class GetPostsUseCase(private val repository: BlogRepository) {

	operator fun invoke() = repository.getPosts()
}