package com.startup.ecoapp.domain.repository

import com.startup.ecoapp.domain.models.Comment
import com.startup.ecoapp.domain.models.Post

interface BlogRepository {
    fun getPosts():List<Post>
    fun getComments():List<Comment>
    fun getPostById():Post
}