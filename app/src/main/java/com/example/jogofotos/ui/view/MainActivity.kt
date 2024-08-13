package com.example.jogofotos.ui.view

import CreateLobbyActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jogofotos.ui.theme.JogoFotosTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : ComponentActivity() {


    lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YourApp()
        }

        auth = Firebase.auth
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        //val currentUser = auth.currentUser
        //updateUI(currentUser)
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
