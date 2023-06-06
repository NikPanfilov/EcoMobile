package com.startup.ecoapp.signup.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.startup.ecoapp.core.network.token.domain.usecase.SaveTokenUseCase
import com.startup.ecoapp.core.network.utils.CoroutineNetworkExceptionHandler
import com.startup.ecoapp.signup.domain.usecase.SignUpUseCase
import kotlinx.coroutines.launch

class SignUpViewModel(
	private val signUpUseClass: SignUpUseCase,
	private val saveTokenUseCase: SaveTokenUseCase
) : ViewModel() {

	private val sendErrorHandler = CoroutineNetworkExceptionHandler { code -> }

	private fun signUp() {
		viewModelScope.launch(sendErrorHandler) {
//			val tokenPair = signUpUseClass()
//			saveTokenUseCase(tokenPair)
		}
	}
}