package com.startup.feature.blogs.presentation

import androidx.lifecycle.ViewModel
import com.startup.ecoapp.core.network.token.domain.usecase.GetUserIdUseCase
import com.startup.feature.blogs.domain.usecase.CreateBlogUseCase
import com.startup.feature.blogs.domain.usecase.GetBlogsUseCase
import com.startup.feature.blogs.domain.usecase.GetUserBlogsUseCase

class BlogsViewModel(
	private val getBlogsUseCase: GetBlogsUseCase,
	private val getUserBlogsUseCase: GetUserBlogsUseCase,
	private val createBlogUseCase: CreateBlogUseCase,
	private val getUserIdUseCase: GetUserIdUseCase
) : ViewModel() {
}