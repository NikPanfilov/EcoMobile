package com.startup.profile.creation.presentation

import androidx.lifecycle.ViewModel
import com.startup.profile.creation.domain.usecase.CreatePostUseCase
import com.startup.profile.creation.domain.usecase.DeletePostUseCase
import com.startup.profile.creation.domain.usecase.EditPostUseCase

class ProfileCreationViewModel(
	private val createPostUseCase: CreatePostUseCase,
	private val deletePostUseCase: DeletePostUseCase,
	private val editPostUseCase: EditPostUseCase
) : ViewModel() {

}