package com.startup.shared.post.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.startup.shared.post.domain.entity.Post
import com.startup.shared.post.domain.repository.PostRepository

class PostsDataSource(
    private val repo: PostRepository
) : PagingSource<Int, Post>() {

    override fun getRefreshKey(state: PagingState<Int, Post>): Int? {
        return state.anchorPosition?.let { position ->
            val page = state.closestPageToPosition(position)
            page?.prevKey?.minus(1) ?: page?.nextKey?.plus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Post> {
        return try {
            val page = params.key ?: 1
            val response = repo.getPosts(page = page.toString(), filter = "")
            LoadResult.Page(
                data = response,
                prevKey = null,
                nextKey = if (response.isNotEmpty()) page + 1 else null
            )
        } catch (e: Exception) {
            if (e.message == "HTTP 404 Not Found")
                LoadResult.Page(
                    data = listOf(),
                    prevKey = null,
                    nextKey = null
                )
            else
                LoadResult.Error(e)
        }
    }

}