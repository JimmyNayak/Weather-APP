package com.jn.weatherapp.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jn.weatherapp.ui.base.LoadingScreen

/**
 * Created on 15-11-2025.
 */

@Composable
fun HomeScreen() {

    val homeViewModel: HomeViewModel = viewModel { HomeViewModel() }
    val homeUiState = homeViewModel.homeUiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        homeViewModel.getWeatherData()
    }

    if (homeUiState.value.isLoading) {
        LoadingScreen()
    } else {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize()
        ) {
            val weatherResponse =
                if (homeUiState.value.isApiSuccessful) homeUiState.value.weatherResponse else "Something went wrong!"
            Text(
                "Weather Response: $weatherResponse", modifier = Modifier.padding(8.dp).verticalScroll(
                    rememberScrollState()
                )
            )
        }
    }
}