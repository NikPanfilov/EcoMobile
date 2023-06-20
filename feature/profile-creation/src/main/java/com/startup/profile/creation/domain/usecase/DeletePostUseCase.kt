package com.startup.profile.creation.domain.usecase

import com.startup.profile.creation.domain.repository.PostCreationRepository

class DeletePostUseCase(private val repository: PostCreationRepository) {

	suspend operator fun invoke(id: String) {
		repository.delete(id)
	}
}