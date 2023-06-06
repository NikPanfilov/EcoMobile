package com.startup.ecoapp.data.storage

import com.startup.ecoapp.domain.models.Comment
import com.startup.ecoapp.domain.models.Post

interface BlogDataStorage {
    fun getPosts():List<Post>
    fun getComments():List<Comment>
    fun getPostById():Post
}