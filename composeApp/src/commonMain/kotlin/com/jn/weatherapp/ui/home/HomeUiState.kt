package com.jn.weatherapp.ui.home

/**
 * Created on 16-11-2025.
 */
class HomeUiState(
    var isLoading: Boolean = false,
    var isApiSuccessful: Boolean = false,
    var weatherResponse:String = ""
)