package com.example.proyecto12

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HonorariosScreen(onBack: () -> Unit) {
    // Estado para almacenar el sueldo bruto ingresado
    var sueldoBruto by remember { mutableStateOf("") }
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título de la pantalla
        Text(text = "Cálculo de Sueldo para Empleados de Honorarios", modifier = Modifier.padding(16.dp))

        // Campo de texto para ingresar el sueldo bruto
        TextField(
            value = sueldoBruto,
            onValueChange = { sueldoBruto = it },
            label = { Text(text = "Sueldo Bruto") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para calcular el sueldo líquido
        Button(onClick = {
            // Convertir el sueldo bruto ingresado a Double o usar 0.0 si no es válido
            val sueldoBrutoDouble = sueldoBruto.toDoubleOrNull() ?: 0.0
            // Crear una instancia de EmpleadoHonorarios con el sueldo bruto proporcionado
            val empleadoHonorarios = EmpleadoHonorarios(sueldoBrutoDouble)
            // Calcular el sueldo líquido utilizando el método en la clase EmpleadoHonorarios
            val liquido = empleadoHonorarios.calcularLiquido()

            // Mostrar el resultado del cálculo utilizando un Toast
            coroutineScope.launch {
                Toast.makeText(context, "Sueldo Líquido: $liquido", Toast.LENGTH_SHORT).show()
            }
        }) {
            Text(text = "Calcular")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para volver al menú principal
        Button(onClick = onBack) {
            Text(text = "Volver")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HonorariosScreenPreview() {
    // Vista previa de HonorariosScreen (no tiene efecto en la funcionalidad)
    HonorariosScreen {

    }
}
