package com.example.jogofotos.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jogofotos.ui.theme.JogoFotosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YourApp()
        }
    }
}

@Composable
fun YourApp() {
    val navController = rememberNavController()

    JogoFotosTheme {
        NavHost(navController = navController, startDestination = "LoginActivity") {
            composable("LoginActivity") {
                LoginActivity(navController)
            }
            composable("MenuActivity") {
                MenuActivity(navController)
            }
            composable("ProfileActivity") {
                ProfileActivity(navController)
            }
            composable("CreateLobbyActivity") {
                CreateLobbyActivity(navController)
            }
        }
    }
}
