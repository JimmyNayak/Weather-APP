package com.jn.weatherapp.navigatin

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jn.weatherapp.ui.home.HomeScreen
import com.jn.weatherapp.ui.login.LoginScreen

/**
 * Created on 16-11-2025.
 */

enum class AppScreens {

    LoginScreen,
    HomeScreen
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.LoginScreen.name) {

        composable(AppScreens.LoginScreen.name) {
            LoginScreen(navController)
        }

        composable(route = AppScreens.HomeScreen.name) {
            HomeScreen()
        }

    }
}