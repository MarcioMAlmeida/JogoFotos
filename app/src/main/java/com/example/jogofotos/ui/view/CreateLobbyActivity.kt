package com.example.jogofotos.ui.view

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateLobbyActivity(navController: NavHostController) {
        Scaffold (
            topBar = {
                TopAppBar(
                    title = {
                        Text("Back")},
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                        }
                    }
                )
            }
        ) {innerPadding ->
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text (
                    text = "Lobby",
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(innerPadding)
                        .padding(16.dp)
                        .align(Alignment.Start),
                )
                LazyColumn(
                    modifier = Modifier
                        .align(Alignment.Start)
                        .border(1.dp, color = Color.Black,shape = RectangleShape)
                        .fillMaxWidth()
                )
                {
                    item{

                    }
                    item {

                        Text (
                            modifier = Modifier
                                .border(1.dp, color = Color.Black,shape = RectangleShape, )
                                .fillMaxWidth(),
                            text = "Usuário",
                            fontSize = 24.sp,
                        )

                    }
                    items(4){index ->
                        Text (
                            modifier = Modifier
                                .border(1.dp, color = Color.Black,shape = RectangleShape, )
                                .fillMaxWidth(),
                            text = "Player: $index",
                            fontSize = 24.sp,
                        )
                    }
                }
            }
        }
}
@Preview
@Composable
fun PreviewCreateLobbyActivity() {
    MaterialTheme {
        CreateLobbyActivity(navController = rememberNavController())
    }
}