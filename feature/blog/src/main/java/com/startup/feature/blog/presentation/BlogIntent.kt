package com.startup.feature.blog.presentation

sealed class BlogIntent {
    data class UpVote(val postId: String) : BlogIntent()
    data class DownVote(val postId: String) : BlogIntent()
    data class CancelVote(val reactionId: String) : BlogIntent()
    object LoadPosts : BlogIntent()
}
