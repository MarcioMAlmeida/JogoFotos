import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun CreateLobbyActivity(navController: NavHostController) {
    val players = remember { mutableStateListOf("Você") } // Lista de jogadores
    val lobbyLink = remember { mutableStateOf("URL_LINK.COM") } // Link do lobby

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Lobby",
            style = MaterialTheme.typography.headlineMedium
        )

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(players) { player ->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Jogador"
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = player)
                }
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        value = lobbyLink.value,
                        onValueChange = { lobbyLink.value = it },
                        readOnly = true,
                        label = { Text("Link do Lobby") }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(onClick = { /* Copiar link para a área de transferência */ }) {
                        Text("Copiar Link")
                    }
                }
            }
        }

        Button(
            onClick = { /* Iniciar partida */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Iniciar Partida")
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
