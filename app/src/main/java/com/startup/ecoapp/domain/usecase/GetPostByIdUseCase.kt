package com.startup.ecoapp.domain.usecase

import com.startup.ecoapp.domain.repository.BlogRepository

class GetPostByIdUseCase (private val repository: BlogRepository){
    operator fun invoke() = repository.getPostById()
}