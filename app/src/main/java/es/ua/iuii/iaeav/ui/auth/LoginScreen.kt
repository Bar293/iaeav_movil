package es.ua.iuii.iaeav.ui.auth

import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.layout.ContentScale
import es.ua.iuii.iaeav.R


/**
 * Pantalla simplificada de inicio: elimina autenticación y muestra un botón "Empezar".
 */
@Composable
fun LoginScreen(contentPadding: PaddingValues, onLogged: () -> Unit, onGoRegister: () -> Unit) {
    Surface(
        modifier = Modifier
            .padding(contentPadding)
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Espacio superior
            Spacer(modifier = Modifier.height(200.dp))

            // Logo de la aplicación
            Image(
                painter = painterResource(id = R.drawable.logo_iaeav_remove),
                contentDescription = "Logo de la App",
                modifier = Modifier.size(120.dp)
            )

            Spacer(Modifier.height(24.dp))

            Text("Bienvenido", style = MaterialTheme.typography.headlineMedium)

            Spacer(Modifier.height(24.dp))

            // Botón único para empezar (reemplaza todo el flujo de autenticación)
            Button(
                onClick = { onLogged() },
            ) {
                Text("Empezar", fontSize = 36.sp)
            }

            // Empuja el footer hacia abajo
            Spacer(modifier = Modifier.weight(1f))

            // Footer: logos de financiación con separación del borde
            Image(
                painter = painterResource(id = R.drawable.logos_financiacion),
                contentDescription = "Logos financiación",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
                    .height(80.dp),
                contentScale = ContentScale.FillWidth
            )
        }
    }
}