package com.example.jogofotos.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
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
fun GameActivity(navController: NavController) {
    var timer by remember { mutableStateOf(60) }

    LaunchedEffect(Unit) {
        // Simular contagem regressiva
        while (timer > 0) {
            kotlinx.coroutines.delay(1000L)
            timer--
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Round 1", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        Row {
                            Text("Timer:", fontSize = 16.sp)
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(timer.toString(), fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                },
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
                text = "Theme: Pets",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            ChatItem(playerName = "Player 1", isCurrentPlayer = false)
            Spacer(modifier = Modifier.height(8.dp))
            ChatItem(playerName = "Me", isCurrentPlayer = true)
            Spacer(modifier = Modifier.height(8.dp))
            ChatItem(playerName = "Player 2", isCurrentPlayer = false)

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    // Navegar para a tela da câmera ou abrir a câmera
                    // navController.navigate("CameraScreen")
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Take Photo")
            }
        }
    }
}

@Composable
fun ChatItem(playerName: String, isCurrentPlayer: Boolean) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = if (isCurrentPlayer) Alignment.End else Alignment.Start
        ) {
            Text(playerName, fontSize = 16.sp, fontWeight = FontWeight.Medium)
            Image(
                imageVector = Icons.Default.AccountBox,
                contentDescription = "Player Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .padding(vertical = 4.dp)
            )
            // Reactions, etc.
        }
    }
}

@Preview
@Composable
fun PreviewGameActivity() {
    MaterialTheme {
        GameActivity(navController = rememberNavController())
    }
}
