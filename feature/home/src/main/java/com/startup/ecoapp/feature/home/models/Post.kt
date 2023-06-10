package com.startup.ecoapp.feature.home.models


data class Post(
    val text: String,
    val title: String,
    val categories: List<String>,
    val avatarImage: String,
    val author: String,
    val time: String,
    val image: String?,
    val upVote: Int,
    val downVote: Int
)
