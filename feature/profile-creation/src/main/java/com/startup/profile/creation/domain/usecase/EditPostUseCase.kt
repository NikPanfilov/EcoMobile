package com.startup.profile.creation.domain.usecase

import com.startup.profile.creation.domain.entity.PostChanges
import com.startup.profile.creation.domain.repository.PostCreationRepository

class EditPostUseCase(private val repository: PostCreationRepository) {

	suspend operator fun invoke(id: String, changes: PostChanges) {
		repository.edit(id, changes)
	}
}