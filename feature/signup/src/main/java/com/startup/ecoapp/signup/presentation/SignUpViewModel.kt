package com.startup.ecoapp.signup.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.startup.ecoapp.core.network.token.domain.usecase.SaveTokenUseCase
import com.startup.ecoapp.core.network.utils.CoroutineNetworkExceptionHandler
import com.startup.ecoapp.signup.domain.entity.SignUpData
import com.startup.ecoapp.signup.domain.usecase.SignUpUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignUpViewModel(
	private val signUpUseClass: SignUpUseCase,
	private val saveTokenUseCase: SaveTokenUseCase
) : ViewModel() {

	private val sendErrorHandler = CoroutineNetworkExceptionHandler { code ->
		_uiState.update {
			it.copy(
				isLoading = false,
				error = code.toString()
			)
		}
	}

	private val _uiState = MutableStateFlow(SignUpState())
	val uiState: Flow<SignUpState>
		get() = _uiState.asStateFlow()

	fun handle(intent: SignUpIntent) {
		when (intent) {
			SignUpIntent.ConfirmSignIn          -> signUp()

			is SignUpIntent.ChangeUserFirstName -> updateFirstName(intent.firstName)

			is SignUpIntent.ChangeUserLastName  -> updateLastName(intent.lastName)

			is SignUpIntent.ChangeUserBirthDate -> updateBirthDate(intent.birthDate)

			is SignUpIntent.ChangeUserPassword  -> updatePassword(intent.password)

			is SignUpIntent.ChangeUserCity      -> updateCity(intent.city)

			is SignUpIntent.ChangeUserPhone     -> updatePhone(intent.phone)

			is SignUpIntent.ChangeUserEmail     -> updateEmail(intent.email)
		}
	}

	private fun signUp() {
		viewModelScope.launch(sendErrorHandler) {
			_uiState.update {
				it.copy(
					isLoading = true
				)
			}

			val tokenPair = signUpUseClass(buildSignUpData())
			saveTokenUseCase(tokenPair)

			_uiState.update {
				it.copy(
					isLoading = false
				)
			}

		}
	}

	private fun buildSignUpData(): SignUpData = SignUpData(
		_uiState.value.firstName,
		_uiState.value.lastName,
		_uiState.value.birthDate,
		_uiState.value.city,
		_uiState.value.phone,
		_uiState.value.email,
		_uiState.value.password
	)

	private fun updateFirstName(name: String) {
		_uiState.update {
			it.copy(firstName = name)
		}
	}

	private fun updateLastName(lastName: String) {
		_uiState.update {
			it.copy(lastName = lastName)
		}
	}

	private fun updateBirthDate(birthDate: String) {
		_uiState.update {
			it.copy(birthDate = birthDate)
		}
	}

	private fun updatePhone(phone: String) {
		_uiState.update {
			it.copy(phone = phone)
		}
	}

	private fun updateEmail(email: String) {
		_uiState.update {
			it.copy(email = email)
		}
	}

	private fun updatePassword(password: String) {
		_uiState.update {
			it.copy(password = password)
		}
	}

	private fun updateCity(city: String) {
		_uiState.update {
			it.copy(city = city)
		}
	}
}