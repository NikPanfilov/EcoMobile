package com.example.signin.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.startup.ecoapp.domain.models.UserSignInData
import com.startup.ecoapp.domain.usecase.SignInUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignInViewModel(
    private val signInUseCase: SignInUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(SignInState())
    val uiState: StateFlow<SignInState> = _uiState.asStateFlow()

    init {

    }

    fun handle(intent: SignInIntent) {
        when (intent) {
            SignInIntent.ConfirmSignIn -> {
                viewModelScope.launch {
                    _uiState.update {
                        it.copy(
                            isLoading = true
                        )
                    }
                    val result = signInUseCase.execute(
                        userData = UserSignInData(
                            _uiState.value.email,
                            _uiState.value.password,
                        )
                    )
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = result.toString()
                        )
                    }
                }
            }

            is SignInIntent.ChangeUserPassword -> {
                _uiState.update {
                    it.copy(password = intent.str)
                }
            }

            is SignInIntent.ChangeUserEmail -> {
                _uiState.update {
                    it.copy(email = intent.str)
                }
            }
        }
    }
}