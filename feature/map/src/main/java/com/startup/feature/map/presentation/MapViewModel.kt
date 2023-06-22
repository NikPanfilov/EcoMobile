package com.startup.feature.map.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.startup.ecoapp.core.network.utils.CoroutineNetworkExceptionHandler
import com.startup.feature.map.domain.usecase.GetMarkersUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MapViewModel(
	private val getMarkersUseCase: GetMarkersUseCase
) : ViewModel() {

	private val _uiState = MutableStateFlow<MapState>(MapState.Content(emptyList()))
	val uiState: Flow<MapState>
		get() = _uiState.asStateFlow()

	private val sendErrorHandler = CoroutineNetworkExceptionHandler { code ->
	}

	private var page = "1"

	init {
		viewModelScope.launch(sendErrorHandler) {
			_uiState.value = MapState.Content(getMarkersUseCase(page = page))
		}
	}
}