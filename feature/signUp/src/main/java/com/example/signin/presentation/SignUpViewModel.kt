package com.example.signin.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.startup.ecoapp.domain.models.UserSignUpData
import com.startup.ecoapp.domain.usecase.SignUpUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val signInUseCase: SignUpUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(SignUpState())
    val uiState: StateFlow<SignUpState> = _uiState.asStateFlow()

    init {

    }

    fun handle(intent: SignUpIntent) {
        when (intent) {
            SignUpIntent.ConfirmSignIn -> {
                viewModelScope.launch {
                    _uiState.update {
                        it.copy(
                            isLoading = true
                        )
                    }
                    val result = signInUseCase.execute(
                        userData = UserSignUpData(
                            _uiState.value.firstName,
                            _uiState.value.lastName,
                            _uiState.value.birthDate,
                            _uiState.value.city,
                            _uiState.value.phone,
                            _uiState.value.email,
                            _uiState.value.password,
                            _uiState.value.confirmPassword,
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

            is SignUpIntent.ChangeUserFirstName -> {
                _uiState.update {
                    it.copy(firstName = intent.str)
                }
            }

            is SignUpIntent.ChangeUserLastName -> {
                _uiState.update {
                    it.copy(lastName = intent.str)
                }
            }

            is SignUpIntent.ChangeUserBirthDate -> {
                _uiState.update {
                    it.copy(birthDate = intent.str)
                }
            }

            is SignUpIntent.ChangeUserPassword -> {
                _uiState.update {
                    it.copy(password = intent.str)
                }
            }

            is SignUpIntent.ChangeUserConfirmPassword -> {
                _uiState.update {
                    it.copy(confirmPassword = intent.str)
                }
            }

            is SignUpIntent.ChangeUserCity -> {
                _uiState.update {
                    it.copy(city = intent.str)
                }
            }

            is SignUpIntent.ChangeUserPhone -> {
                _uiState.update {
                    it.copy(phone = intent.str)
                }
            }

            is SignUpIntent.ChangeUserEmail -> {
                _uiState.update {
                    it.copy(email = intent.str)
                }
            }

        }
    }
}