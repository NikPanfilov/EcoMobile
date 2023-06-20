package com.startup.feature.blog.presentation

import androidx.lifecycle.ViewModel
import com.startup.ecoapp.core.network.token.domain.usecase.GetUserIdUseCase
import com.startup.feature.blog.domain.usecase.DeleteBlogUseCase
import com.startup.feature.blog.domain.usecase.EditBlogUseCase
import com.startup.feature.blog.domain.usecase.GetBlogUseCase

class BlogViewModel(
	private val getBlogUseCase: GetBlogUseCase,
	private val editBlogUseCase: EditBlogUseCase,
	private val deleteBlogUseCase: DeleteBlogUseCase,
	private val getUserIdUseCase: GetUserIdUseCase
) : ViewModel() {

}