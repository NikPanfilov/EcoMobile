package com.startup.shared.comment.data.api

import com.startup.shared.comment.data.dto.CommentResponseDto
import com.startup.shared.comment.data.dto.CreatedCommentDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface CommentApi {

	@GET("api/posts/{id}/comments")
	suspend fun getComments(
		@Path("id") id: String,
		@Query("filter") filter: String,
		@Query("page") page: String
	): CommentResponseDto

	@POST("api/comments")
	suspend fun createComment(@Body comment: CreatedCommentDto)
}