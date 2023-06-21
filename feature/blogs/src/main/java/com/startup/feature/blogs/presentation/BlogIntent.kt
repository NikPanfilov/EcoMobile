package com.startup.feature.blog.presentation

import com.startup.feature.blogs.domain.entity.Blog

sealed class BlogsIntent {
    object LoadBlogs : BlogsIntent()
    object CreateBlog: BlogsIntent()
}
