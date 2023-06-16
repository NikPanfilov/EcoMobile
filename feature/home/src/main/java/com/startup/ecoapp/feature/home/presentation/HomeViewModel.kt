package com.startup.ecoapp.feature.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.startup.ecoapp.core.network.token.domain.usecase.GetUserIdUseCase
import com.startup.ecoapp.core.network.utils.CoroutineNetworkExceptionHandler
import com.startup.shared.post.domain.usecase.GetPostsUseCase
import com.startup.shared.reactions.domain.usecase.CancelVoteUseCase
import com.startup.shared.reactions.domain.usecase.DownVoteUseCase
import com.startup.shared.reactions.domain.usecase.UpVoteUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
	private val getPostsUseCase: GetPostsUseCase,
	private val getUserIdUseCase: GetUserIdUseCase,
	private val cancelVoteUseCase: CancelVoteUseCase,
	private val downVoteUseCase: DownVoteUseCase,
	private val upVoteUseCase: UpVoteUseCase,
) : ViewModel() {

	//private val userId = getUserIdUseCase()

	private val _uiState = MutableStateFlow(HomeState())
	val uiState: StateFlow<HomeState> = _uiState.asStateFlow()

	val postPager = Pager(
		PagingConfig(pageSize = 10)
	) {
		getPostsUseCase("")
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
			is HomeIntent.UpVote            -> upVote(intent.postId)
			is HomeIntent.DownVote          -> downVote(intent.postId)
			is HomeIntent.CancelVote        -> cancelVote(intent.reactionId)
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