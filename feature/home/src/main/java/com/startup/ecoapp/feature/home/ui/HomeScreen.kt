package com.startup.ecoapp.feature.home.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.rememberAsyncImagePainter
import com.startup.ecoapp.feature.home.R
import com.startup.ecoapp.feature.home.presentation.HomeIntent
import com.startup.ecoapp.feature.home.presentation.HomeViewModel
import com.startup.shared.post.domain.entity.Post
import org.koin.androidx.compose.koinViewModel
import com.startup.theme.R as ThemeR

@Composable
fun HomeScreen(navController: NavController, homeViewModel: HomeViewModel = koinViewModel()) {

    val state by homeViewModel.uiState.collectAsState()
    val postList = homeViewModel.postPager.collectAsLazyPagingItems()

    Scaffold(bottomBar = { NavigationBottomBar() }, topBar = { NavigationTopBar() }) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
                .padding(paddingValues = it)
                .padding(start = 20.dp, end = 20.dp)
        ) {
            items(postList.itemCount) { i ->
                postList[i]?.let { it1 ->
                    Post(it1, onClick = {
                        navController.navigate("post_screen/${postList[i]?.id}")
                    }, onDownVoteClick = {
                        homeViewModel.handle(HomeIntent.UpVote(state.posts[i].id))
                    }, onUpVoteClick = {
                        homeViewModel.handle(HomeIntent.DownVote(state.posts[i].id))
                    })
                }

            }
            when (postList.loadState.append) {
                is LoadState.NotLoading -> Unit
                LoadState.Loading -> item {
                    CircularProgressIndicator()
                }

                is LoadState.Error -> item {
                    ErrorItem(message = "Some error occurred")
                }
            }

            when (postList.loadState.refresh) {
                is LoadState.NotLoading -> Unit
                LoadState.Loading ->
                    item {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            LoadingItem()
                        }
                    }

                is LoadState.Error -> item {
                    ErrorItem(message = "Some error occurred")
                }
            }
        }
    }
}

@Composable
fun Post(
    post: Post,
    onClick: () -> Unit,
    onUpVoteClick: () -> Unit,
    onDownVoteClick: () -> Unit,
) {
    Card() {
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Image(
                    painter = /*rememberAsyncImagePainter(post.blogAvatar),*/painterResource(
                        androidx.appcompat.R.drawable.abc_ic_commit_search_api_mtrl_alpha
                    ),
                    contentDescription = "avatar",
                    modifier = Modifier.size(40.dp)
                )
                Text(post.blogTitle, style = MaterialTheme.typography.titleSmall)
                Text(post.created.toString(), color = Color.Gray)
            }
            Text(text = "${post.authorFirstName} ${post.authorLastName}", color = Color.Gray)
            LazyRow(Modifier.fillMaxWidth()) {
                items(post.categories.size) {
                    PostType(type = post.categories[it].name)
                }
            }
            Text(post.title, style = MaterialTheme.typography.titleLarge)
            if (post.photos != null) Image(
                rememberAsyncImagePainter(post.photos),
                contentDescription = "postImage",
                modifier = Modifier.fillMaxWidth()
            )
            var postText = ""
            if (post.text.length > 100) postText = post.text.subSequence(0, 100).toString() + "..."
            Text(postText, color = Color.Gray,
                modifier = Modifier.clickable { onClick() })
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    /*
                    if (post. == LIKE)
                        Icon(
                            painterResource(id = ThemeR.drawable.thumb_up),
                            contentDescription = "upVote",
                            modifier = Modifier.clickable {
                                onUpVoteClick()
                            },
                            tint = MaterialTheme.colorScheme.primary
                        )
                    else

                     */
                    Icon(painterResource(id = ThemeR.drawable.thumb_up),
                        contentDescription = "upVote",
                        modifier = Modifier.clickable {
                            onUpVoteClick()
                        }
                    )
                    Text(post.likes.toString())
                    /*if (post.userReaction == DISLIKE)
                    Icon(
                        painterResource(id = ThemeR.drawable.thumb_down),
                        contentDescription = "downVote",
                        modifier = Modifier.clickable {
                            onDownVoteClick()
                        },
                        tint = MaterialTheme.colorScheme.primary
                    )
                else
                */
                    Icon(
                        painterResource(id = ThemeR.drawable.thumb_down),
                        contentDescription = "downVote",
                        modifier = Modifier.clickable {
                            onDownVoteClick()
                        })
                }
            }

        }
    }
}

@Composable
fun LoadingItem() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .width(42.dp)
                .height(42.dp)
                .padding(8.dp),
            strokeWidth = 5.dp
        )

    }
}

@Composable
fun ErrorItem(message: String) {
    Card(
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Box() {
            Text(
                color = Color.White,
                text = message,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(start = 12.dp)
                    .align(Alignment.Center)
            )
        }
    }
}

@Composable
fun NavigationTopBar() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)

    ) {
        Image(imageVector = Icons.Default.Menu, contentDescription = "menu", Modifier.size(30.dp))
        Image(
            imageVector = Icons.Default.Search, contentDescription = "search", Modifier.size(30.dp)
        )
    }

}

@Composable
fun NavigationBottomBar() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)

    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(imageVector = Icons.Default.Home, contentDescription = "home")
            Text("Home")
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painterResource(id = R.drawable.question_answer), contentDescription = "chat")
            Text("Chat")
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(imageVector = Icons.Default.Add, contentDescription = "add")
            Text("Create")
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(imageVector = Icons.Default.Person, contentDescription = "profile")
            Text("Profile")
        }
    }
}

@Composable
fun PostType(type: String) {
    Surface(
        shape = RoundedCornerShape(5.dp),
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .padding(end = 5.dp, bottom = 5.dp)
            .height(25.dp),
    ) {
        Text(
            text = type,
            style = MaterialTheme.typography.bodySmall,
            color = Color.White,
            modifier = Modifier.padding(5.dp),

            )
    }
}


@Composable
@Preview
fun Preview() {
    HomeScreen(navController = rememberNavController())
}