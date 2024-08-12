package com.example.jogofotos.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun ProfileActivity(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.5f)) // Fundo embaçado
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .align(Alignment.Center),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.size(24.dp)
                    )
                }

                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .background(Color.Gray)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Nome",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                ProfileStats(label = "Partidas Jogadas:", value = "58")
                ProfileStats(label = "Número de vitórias:", value = "42")
                ProfileStats(label = "Pontuação Média:", value = "41")
                ProfileStats(label = "Pontuação Total:", value = "2378")
            }
        }
    }
}

@Composable
fun ProfileStats(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, fontSize = 16.sp)
        Text(text = value, fontSize = 16.sp, color = MaterialTheme.colorScheme.primary)
    }
}

@Preview
@Composable
fun PreviewProfileActivity() {
    MaterialTheme {
        ProfileActivity(navController = rememberNavController())
    }
}
