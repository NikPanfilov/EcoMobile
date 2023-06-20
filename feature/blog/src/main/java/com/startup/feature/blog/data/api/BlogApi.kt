package com.startup.feature.blog.data.api

import com.startup.feature.blog.data.dto.BlogChangesDto
import com.startup.feature.blog.data.dto.BlogDto
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Query

interface BlogApi {

	@GET("api/blog/{id}")
	suspend fun getBlog(@Query("id") id: String): BlogDto

	@PUT("api/blog/{id}")
	suspend fun editBlog(@Query("id") id: String, @Body changes: BlogChangesDto)

	@DELETE("api/blog/{id}")
	suspend fun deleteBlog(@Query("id") id: String)
}