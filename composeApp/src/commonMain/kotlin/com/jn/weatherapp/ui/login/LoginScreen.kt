package com.jn.weatherapp.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.jn.weatherapp.navigatin.AppScreens
import com.jn.weatherapp.ui.base.LoadingScreen

/**
 * Created on 15-11-2025.
 */

@Composable
fun LoginScreen(navController: NavHostController) {
    val loginViewModel: LoginViewModel = viewModel { LoginViewModel() }

    var userName by remember { mutableStateOf(TextFieldValue("")) }
    var userPassword by remember { mutableStateOf(TextFieldValue("")) }
    val loginUiState = loginViewModel.loginUiState.collectAsStateWithLifecycle()

    if (loginUiState.value.isLoginSuccessful) {
        navController.navigate(AppScreens.HomeScreen.name)
    }

    if (loginUiState.value.isLoading) {
        LoadingScreen()
    } else {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            OutlinedTextField(
                value = userName,
                onValueChange = { userName = it },
                placeholder = { Text("User Name") },
                label = { Text("User Name") })

            OutlinedTextField(
                value = userPassword,
                onValueChange = { userPassword = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                placeholder = { Text("Password") }
            )

            Button(
                modifier = Modifier.padding(16.dp),
                onClick = { loginViewModel.performLogin() },
                enabled = userName.text.isNotEmpty() && userPassword.text.isNotEmpty()
            ) {
                Text("Login")
            }
        }
    }
}