package es.ua.iuii.iaeav.ui.results

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

/**
 * # Pantalla de Resultados (ResultScreen)
 *
 * Composable que muestra los resultados de la grabación tras completarse
 * el procesamiento en la pantalla de carga.
 *
 * @param onBack Callback para volver atrás al registro.
 * @param onLogout Callback para navegar a la pantalla de Login y cerrar la sesión.
 * @param onNavigateToProfile Callback para navegar a la pantalla de perfil.
 * @param onNavigateToInfo Callback para navegar a la pantalla de información.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultScreen(
    onBack: () -> Unit,
    onLogout: () -> Unit = {},
    onNavigateToProfile: () -> Unit = {},
    onNavigateToInfo: () -> Unit = {}
) {
    var showMenu by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Resultados de la prueba") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                ),
                actions = {
                    // Icono de menú (tres puntos) que controla la visibilidad de [DropdownMenu]
                    IconButton(onClick = { showMenu = true }) {
                        Icon(Icons.Default.MoreVert, contentDescription = "Menú")
                    }

                    // Menú desplegable con opciones de navegación y sesión
                    DropdownMenu(
                        expanded = showMenu,
                        onDismissRequest = { showMenu = false } // Se cierra al tocar fuera
                    ) {
                        DropdownMenuItem(
                            text = { Text("Mi Cuenta") },
                            onClick = {
                                showMenu = false
                                onNavigateToProfile() // Navegación al perfil
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Información de la App") },
                            onClick = {
                                showMenu = false
                                onNavigateToInfo() // Navegación a información
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Cerrar Sesión") },
                            onClick = {
                                showMenu = false
                                onLogout() // Cierre de sesión y navegación al login
                            }
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Resultados de la prueba",
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Su grabación ha sido procesada exitosamente.",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(32.dp))
            //
            Button(
                onClick = onBack,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text("Volver al Inicio")
            }
            //
        }
    }
}