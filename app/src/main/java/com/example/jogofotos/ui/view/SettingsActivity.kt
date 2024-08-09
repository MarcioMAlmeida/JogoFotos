import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun SettingsActivity(navController: NavHostController) {
    var isNotificationsEnabled by remember { mutableStateOf(true) } // Estado para controlar as notificações

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Seção de informações do usuário
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "Perfil"
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Nome do Usuário")
        }

        // Email
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Email:")
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "fulanodetal@email.com")
            IconButton(onClick = { /* Ação para editar o email */ }) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = "Editar email")
            }
        }

        // Senha
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Senha:")
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "********")
            IconButton(onClick = { /* Ação para editar a senha */ }) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = "Editar senha")
            }
        }

        // Notificações
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Notificações:")
            Spacer(modifier = Modifier.weight(1f))
            Switch(
                checked = isNotificationsEnabled,
                onCheckedChange = { isNotificationsEnabled = it }
            )
        }

        // Botão de logout
        Button(
            onClick = { /* Ação para fazer logout */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Logout")
        }
    }
}

@Preview
@Composable
fun PreviewSettingsActivity() {
    MaterialTheme {
        SettingsActivity(navController = rememberNavController())
    }
}
