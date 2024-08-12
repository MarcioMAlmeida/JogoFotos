package com.example.jogofotos.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jogofotos.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultActivity(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Resultado") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Resultado",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            ResultItem(playerName = "Davis Curtis", points = 45, isWinner = true)
            ResultItem(playerName = "Alena Donin", points = 39, isWinner = false)
            ResultItem(playerName = "Craig Goose", points = 32, isWinner = false)
            ResultItem(playerName = "Madelyn Dias", points = 28, isWinner = false)
            ResultItem(playerName = "Zain Vaccaro", points = 16, isWinner = false)

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    // Implementar navegação ou funcionalidade de continuar
                },
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Continuar")
            }
        }
    }
}

@Composable
fun ResultItem(playerName: String, points: Int, isWinner: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(color = Color(0xFFE0E0E0), shape = RoundedCornerShape(12.dp))
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.White)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = playerName,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "$points pontos",
                fontSize = 16.sp,
                color = Color.Gray
            )
        }

        if (isWinner) {
            Icon(
                imageVector = Icons.Default.Face,
                contentDescription = "Winner Icon",
                modifier = Modifier.size(24.dp),
                tint = Color(0xFFFFD700)
            )
        }
    }
}

@Preview
@Composable
fun PreviewResultActivity() {
    MaterialTheme {
        ResultActivity(navController = rememberNavController())
    }
}
