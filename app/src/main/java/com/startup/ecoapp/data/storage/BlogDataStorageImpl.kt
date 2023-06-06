package com.startup.ecoapp.data.storage

import com.startup.ecoapp.domain.models.Post
import com.startup.ecoapp.R
import com.startup.ecoapp.domain.models.Author
import com.startup.ecoapp.domain.models.Comment

class BlogDataStorageImpl : BlogDataStorage {
    override fun getPosts(): List<Post> = listOf(
        Post(
            text = "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "",
            avatarId = R.drawable.profile_image,
            header = "Some header",
            imageId = R.drawable.post_image,
            time = "2 hr ago",
            upVote = 625,
            downVote = 100,
            types = listOf("Общее", "длиннопост"),
            author = "AuthorNickname"
        ),
        Post(
            text = "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "",
            avatarId = R.drawable.profile_image,
            header = "Some header",
            imageId = R.drawable.post_image,
            time = "2 hr ago",
            upVote = 625,
            downVote = 100,
            types = listOf("Общее", "длиннопост"),
            author = "AuthorNickname"
        ),
        Post(
            text = "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "",
            avatarId = R.drawable.profile_image,
            header = "Some header",
            imageId = R.drawable.post_image,
            time = "2 hr ago",
            upVote = 625,
            downVote = 100,
            types = listOf("Общее", "длиннопост"),
            author = "AuthorNickname"
        ),
        Post(
            text = "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "",
            avatarId = R.drawable.profile_image,
            header = "Some header",
            imageId = R.drawable.post_image,
            time = "2 hr ago",
            upVote = 625,
            downVote = 100,
            types = listOf("Общее", "длиннопост"),
            author = "AuthorNickname"
        ),
        Post(
            text = "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "",
            avatarId = R.drawable.profile_image,
            header = "Some header",
            imageId = R.drawable.post_image,
            time = "2 hr ago",
            upVote = 625,
            downVote = 100,
            types = listOf("Общее", "длиннопост"),
            author = "AuthorNickname"
        ),
        Post(
            text = "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "",
            avatarId = R.drawable.profile_image,
            header = "Some header",
            imageId = R.drawable.post_image,
            time = "2 hr ago",
            upVote = 625,
            downVote = 100,
            types = listOf("Общее", "длиннопост"),
            author = "AuthorNickname"
        ),
        Post(
            text = "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "This is example of post text." +
                    "",
            avatarId = R.drawable.profile_image,
            header = "Some header",
            imageId = R.drawable.post_image,
            time = "2 hr ago",
            upVote = 625,
            downVote = 100,
            types = listOf("Общее", "длиннопост"),
            author = "AuthorNickname"
        ),
    )

    override fun getComments(): List<Comment> = listOf(
        Comment(
            author = Author(
                avatarId = R.drawable.profile_image,
                nickname = "AuthorNickname"
            ),
            text = "This is example of comment text" +
                    "This is example of comment text" +
                    "This is example of comment text" +
                    "This is example of comment text",
            time = "20 min ago",
            likes = 123
        ),
        Comment(
            author = Author(
                avatarId = R.drawable.profile_image,
                nickname = "AuthorNickname"
            ),
            text = "This is example of comment text" +
                    "This is example of comment text" +
                    "This is example of comment text" +
                    "This is example of comment text",
            time = "20 min ago",
            likes = 123
        ),
        Comment(
            author = Author(
                avatarId = R.drawable.profile_image,
                nickname = "AuthorNickname"
            ),
            text = "This is example of comment text" +
                    "This is example of comment text" +
                    "This is example of comment text" +
                    "This is example of comment text",
            time = "20 min ago",
            likes = 123
        ),
        Comment(
            author = Author(
                avatarId = R.drawable.profile_image,
                nickname = "AuthorNickname"
            ),
            text = "This is example of comment text" +
                    "This is example of comment text" +
                    "This is example of comment text" +
                    "This is example of comment text",
            time = "20 min ago",
            likes = 123
        ),
    )

    override fun getPostById(): Post = Post(
        text = "This is example of post text." +
                "This is example of post text." +
                "This is example of post text." +
                "This is example of post text." +
                "This is example of post text." +
                "This is example of post text." +
                "This is example of post text." +
                "This is example of post text." +
                "This is example of post text." +
                "This is example of post text." +
                "",
        avatarId = R.drawable.profile_image,
        header = "Some header",
        imageId = R.drawable.post_image,
        time = "2 hr ago",
        upVote = 625,
        downVote = 100,
        types = listOf("Общее", "длиннопост"),
        author = "AuthorNickname"
    )


}