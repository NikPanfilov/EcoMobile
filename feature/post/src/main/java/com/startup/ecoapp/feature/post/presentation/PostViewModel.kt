package com.startup.ecoapp.feature.post.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.startup.shared.post.domain.usecase.GetCommentsUseCase
import com.startup.shared.post.domain.usecase.GetPostByIdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PostViewModel(
	private val getCommentsUseCase: GetCommentsUseCase,
	private val getPostByIdUseCase: GetPostByIdUseCase
) : ViewModel() {

	private val _uiState = MutableStateFlow(PostState())
	val uiState: StateFlow<PostState> = _uiState.asStateFlow()


	val postPager = Pager(
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

	}

	fun handle(intent: HomeIntent) {
		when (intent) {
			is HomeIntent.UpVote -> upVote(intent.postId)
			is HomeIntent.DownVote -> downVote(intent.postId)
			is HomeIntent.CancelVote -> cancelVote(intent.reactionId)
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
			cancelVoteUseCase(postId)
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
