package com.startup.profile.creation.domain.usecase

import com.startup.profile.creation.domain.entity.Post
import com.startup.profile.creation.domain.repository.PostCreationRepository

class CreatePostUseCase(private val repository: PostCreationRepository) {

	suspend operator fun invoke(post: Post) {
		repository.create(post)
	}
}