package com.startup.profile.creation.data.repository

import com.startup.profile.creation.data.api.PostCreationApi
import com.startup.profile.creation.data.mapper.toDto
import com.startup.profile.creation.domain.entity.Post
import com.startup.profile.creation.domain.entity.PostChanges
import com.startup.profile.creation.domain.repository.PostCreationRepository

class PostCreationRepositoryImpl(private val api: PostCreationApi) : PostCreationRepository {

	override suspend fun create(post: Post) {
		api.create(post.toDto())
	}

	override suspend fun edit(id: String, changes: PostChanges) {
		api.edit(id, changes.toDto())
	}

	override suspend fun delete(id: String) {
		api.delete(id)
	}
}