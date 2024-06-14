package com.example.jogofotos.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jogofotos.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileActivity(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Back") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        bottomBar = {
            BottomNavigation {
                BottomNavigationItem(
                    icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = false,
                    onClick = { navController.navigate("MenuActivity") }
                )
                BottomNavigationItem(
                    icon = { /* Placeholder for other icons */ },
                    label = { Text("Messages") },
                    selected = false,
                    onClick = { /* Handle messages navigation */ }
                )
                BottomNavigationItem(
                    icon = { /* Placeholder for other icons */ },
                    label = { Text("Search") },
                    selected = false,
                    onClick = { /* Handle search navigation */ }
                )
                BottomNavigationItem(
                    icon = { /* Placeholder for other icons */ },
                    label = { Text("Profile") },
                    selected = true,
                    onClick = { /* Handle profile navigation */ }
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 24.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "Profile Picture",
                    modifier = Modifier.size(64.dp)
                )
                Column(
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    Text(text = "John Doe", fontSize = 24.sp)
                    Text(text = "Alberta, CA", fontSize = 16.sp)
                }
            }

            // Grid-like layout for images
            val imageModifier = Modifier
                .aspectRatio(1f)
                .padding(4.dp)
                .weight(1f)

            Column {
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "Photo 1",
                        modifier = imageModifier
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "Photo 2",
                        modifier = imageModifier
                    )
                }
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "Photo 3",
                        modifier = imageModifier
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "Photo 4",
                        modifier = imageModifier
                    )
                }
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "Photo 5",
                        modifier = imageModifier
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "Photo 6",
                        modifier = imageModifier
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewProfileScreen() {
    MaterialTheme {
        ProfileActivity(navController = rememberNavController())
    }
}
