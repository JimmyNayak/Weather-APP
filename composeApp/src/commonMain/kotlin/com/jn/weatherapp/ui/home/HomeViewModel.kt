package com.jn.weatherapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jn.weatherapp.api.WeatherComponent
import com.jn.weatherapp.util.ApiConstants
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * Created on 16-11-2025.
 */
class HomeViewModel : ViewModel() {

    private val _homeUiState = MutableStateFlow(HomeUiState())
    val homeUiState: StateFlow<HomeUiState> = _homeUiState.asStateFlow()

    fun getWeatherData() {
        viewModelScope.launch {

            updateUiState(isLoading = true, isApiSuccessful = false, "")
            val responseData =
                WeatherComponent().httpClient.get(ApiConstants.WEATHER_API_URL).body<WeatherResponseModel>()
                    .toString()
            updateUiState(isLoading = false, isApiSuccessful = responseData.isNotEmpty(), response = responseData)

        }
    }

    private fun updateUiState(isLoading: Boolean, isApiSuccessful: Boolean, response: String) {
        _homeUiState.update {
            HomeUiState(isLoading, isApiSuccessful, weatherResponse = response)
        }
    }
}