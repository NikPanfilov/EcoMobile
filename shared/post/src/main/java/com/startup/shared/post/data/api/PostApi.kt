package com.startup.shared.post.data.api

import com.startup.shared.post.data.dto.CommentsResponseDto
import com.startup.shared.post.data.dto.PostDto
import com.startup.shared.post.data.dto.PostResponseDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface PostApi {

    @GET("api/posts")
    suspend fun getPosts(
        @Query("filter") filter: String,
        @Query("page") page: String
    ): PostResponseDto

    @GET("api/posts/{id}")
    suspend fun getPost(@Path("id") id: String): PostDto

    @GET("api/posts/{id}/comments")
    suspend fun getComments(
        @Path("id") id: String,
        @Query("filter") filter: String,
        @Query("page") page: String
    ): CommentsResponseDto

    @POST("api/comments")
    suspend fun createComment(
        @Body userId: String,
        @Body postId: String,
        @Body commentText: String
    ): Unit //Надо потом поменять на нормальный ответ и обрабатывать
}