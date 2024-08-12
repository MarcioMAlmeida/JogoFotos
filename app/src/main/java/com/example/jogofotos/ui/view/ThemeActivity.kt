import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun ThemeActivity(navController: NavHostController) {
    var theme by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = theme,
            onValueChange = { theme = it },
            label = { Text("Escolha o tema para a rodada") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /* Lógica para confirmar o tema */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Ready")
        }
    }
}

@Preview
@Composable
fun PreviewThemeActivity() {
    MaterialTheme {
        ThemeActivity(navController = rememberNavController())
    }
}