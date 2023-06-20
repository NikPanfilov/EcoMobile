package com.startup.profile.creation.domain.repository

import com.startup.profile.creation.domain.entity.Post
import com.startup.profile.creation.domain.entity.PostChanges

interface PostCreationRepository {

	suspend fun create(post: Post)

	suspend fun edit(id: String, changes: PostChanges)

	suspend fun delete(id: String)
}