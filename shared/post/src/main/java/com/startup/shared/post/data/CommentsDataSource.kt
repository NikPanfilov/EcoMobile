package com.startup.shared.post.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.startup.shared.post.domain.entity.Comment
import com.startup.shared.post.domain.repository.PostRepository

class CommentsDataSource(
    private val repo: PostRepository,
    private val id: String,
    private val filter: String,
) : PagingSource<Int, Comment>() {

    override fun getRefreshKey(state: PagingState<Int, Comment>): Int? {
        return state.anchorPosition?.let { position ->
            val page = state.closestPageToPosition(position)
            page?.prevKey?.minus(1) ?: page?.nextKey?.plus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Comment> {
        return try {
            val page = params.key ?: 1
            val response = repo.getComments(page = page.toString(), filter = "", id = id)
            LoadResult.Page(
                data = response,
                prevKey = null,
                nextKey = if (response.isNotEmpty()) page + 1 else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}