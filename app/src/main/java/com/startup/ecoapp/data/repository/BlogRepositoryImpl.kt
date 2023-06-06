package com.startup.ecoapp.data.repository

import com.startup.ecoapp.data.storage.BlogDataStorage
import com.startup.ecoapp.domain.models.Comment
import com.startup.ecoapp.domain.models.Post
import com.startup.ecoapp.domain.repository.BlogRepository

class BlogRepositoryImpl(private val dataStorage:BlogDataStorage):BlogRepository {
    override fun getPosts() = dataStorage.getPosts()
    override fun getComments(): List<Comment> = dataStorage.getComments()
    override fun getPostById(): Post = dataStorage.getPostById()
}