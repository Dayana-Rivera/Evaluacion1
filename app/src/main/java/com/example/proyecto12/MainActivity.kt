package com.example.proyecto12

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.lifecycleScope
import com.example.proyecto12.ui.theme.Proyecto12Theme
import kotlinx.coroutines.launch

enum class Screen {
    MAIN, HONORARIOS, CONTRATO
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Proyecto12Theme {
                // Contenedor Surface usando el color de fondo del tema
                Surface(modifier = Modifier.fillMaxSize()) {
                    MainScreen() // Lanzar la pantalla principal
                }
            }
        }
    }

    @Composable
    fun MainScreen() {
        var currentScreen by remember { mutableStateOf(Screen.MAIN) }
        val context = LocalContext.current

        when (currentScreen) {
            Screen.MAIN -> {
                // Diseño de la pantalla principal con botones para cambiar a otras pantallas
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(onClick = {
                        currentScreen = Screen.HONORARIOS // Cambiar a la pantalla de honorarios
                    }, modifier = Modifier.padding(8.dp)) {
                        Text(text = "Calcular sueldo Honorarios")
                    }

                    Button(onClick = {
                        currentScreen = Screen.CONTRATO // Cambiar a la pantalla de contrato
                    }, modifier = Modifier.padding(8.dp)) {
                        Text(text = "Calcular sueldo contrato")
                    }
                }
            }

            Screen.HONORARIOS -> HonorariosScreen {
                currentScreen = Screen.MAIN // Volver a la pantalla principal desde la pantalla de honorarios
            }
            Screen.CONTRATO -> {
                launchContratoScreen(context) // Lanzar la pantalla de contrato
            }
        }
    }

    // Función para lanzar la pantalla de contrato
    private fun launchContratoScreen(context: Context) {
        val intent = Intent(context, ContratoScreen::class.java)
        startActivity(intent)
    }

    @Preview(showBackground = true)
    @Composable
    fun MainScreenPreview() {
        Proyecto12Theme {
            MainScreen()
        }
    }
}
