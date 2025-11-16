package com.jn.weatherapp.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * Created on 16-11-2025.
 */
class LoginViewModel : ViewModel() {

    private val _loginUiState = MutableStateFlow(LoginUiState())
    val loginUiState: StateFlow<LoginUiState> = _loginUiState.asStateFlow()

    fun performLogin() {
        viewModelScope.launch {
            updateUiState(isLoading = true, isLoginSuccessful = false)
            delay(2000)
            updateUiState(isLoading = false, isLoginSuccessful = true)

        }
    }

    private fun updateUiState(isLoading: Boolean, isLoginSuccessful: Boolean) {
        _loginUiState.update {
            LoginUiState(isLoading, isLoginSuccessful)
        }
    }
}