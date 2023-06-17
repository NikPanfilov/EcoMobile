package com.startup.ecoapp.feature.post.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.startup.ecoapp.core.network.token.domain.usecase.GetUserIdUseCase
import com.startup.ecoapp.core.network.utils.CoroutineNetworkExceptionHandler
import com.startup.shared.post.domain.usecase.CreateCommentUseCase
import com.startup.shared.post.domain.usecase.GetCommentsUseCase
import com.startup.shared.post.domain.usecase.GetPostByIdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PostViewModel(
	private val getCommentsUseCase: GetCommentsUseCase,
	private val getPostByIdUseCase: GetPostByIdUseCase,
	private val createCommentUseCase: CreateCommentUseCase,
	private val getUserIdUseCase: GetUserIdUseCase
) : ViewModel() {

	private val _uiState = MutableStateFlow(PostState())
	val uiState: StateFlow<PostState> = _uiState.asStateFlow()
	//private val userId = getUserIdUseCase()

	val commentPager = Pager(
		PagingConfig(pageSize = 10)
	) {
		getCommentsUseCase(id = "8ad0dc60-6ddc-4843-912a-198e9e915872")
	}.flow.cachedIn(viewModelScope)

	private val sendErrorHandler = CoroutineNetworkExceptionHandler { code ->
		_uiState.update {
			it.copy(
				isLoading = false,
				error = code.toString()
			)
		}
	}

	init {
		loadPost()
	}

	fun handle(intent: PostIntent) {
		when (intent) {
			is PostIntent.UpdateUserComment -> updateUserComment(intent.text)
			is PostIntent.UpVote -> upVote(intent.postId)
			is PostIntent.DownVote -> downVote(intent.postId)
			is PostIntent.CancelVote -> cancelVote(intent.reactionId)
			is PostIntent.CommentUpVote -> upVote(intent.commentId)
			is PostIntent.CommentDownVote -> downVote(intent.commentId)
			is PostIntent.CommentCancelVote -> cancelVote(intent.reactionId)
			is PostIntent.CreateComment -> createComment(
				commentText = intent.text,
				postId = intent.postId
			)

			is PostIntent.LoadPost -> loadPost()
		}
	}

	private fun updateUserComment(text: String) {
		_uiState.update {
			it.copy(userComment = text)
		}
	}

	private fun loadPost() {
		viewModelScope.launch(sendErrorHandler) {
			startLoading()
			_uiState.update {
				it.copy(post = getPostByIdUseCase("8ad0dc60-6ddc-4843-912a-198e9e915872"))
			}
			endLoading()
		}
	}

	private fun createComment(commentText: String, postId: String) {
		_uiState.update {
			it.copy(userComment = "")
		}
		viewModelScope.launch(sendErrorHandler) {
			startLoading()
			createCommentUseCase(commentText = commentText, postId = postId, userId = /*userId*/ "")
			endLoading()
		}
	}

	private fun upVote(postId: String) {
		viewModelScope.launch(sendErrorHandler) {
			startLoading()
			//upVoteUseCase(Reaction(userId = userId, postId = postId, reaction = LIKE))
			endLoading()
		}
	}

	private fun downVote(postId: String) {
		viewModelScope.launch(sendErrorHandler) {
			startLoading()
			//downVoteUseCase(Reaction(userId = userId, postId = postId, reaction = DISLIKE))
			endLoading()
		}
	}

	private fun cancelVote(postId: String) {
		viewModelScope.launch(sendErrorHandler) {
			startLoading()
			//cancelVoteUseCase(postId)
			endLoading()
		}
	}

	private fun startLoading() {
		_uiState.update { it.copy(isLoading = true) }
	}

	private fun endLoading() {
		_uiState.update { it.copy(isLoading = false) }
	}
}
