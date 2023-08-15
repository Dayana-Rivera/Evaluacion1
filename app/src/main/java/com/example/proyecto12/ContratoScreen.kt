package com.example.proyecto12

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ContratoScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Establecer el diseño de la interfaz de usuario para esta actividad
        setContentView(R.layout.empleado_contrato)

        // Obtener referencias a los elementos de la interfaz de usuario
        val sueldoBrutoEditText = findViewById<EditText>(R.id.sueldoBrutoEditText)
        val calcularButton = findViewById<Button>(R.id.calcularButton)
        val volverButton = findViewById<Button>(R.id.volverButton)

        // Definir el comportamiento cuando se hace clic en el botón "Calcular"
        calcularButton.setOnClickListener {
            // Obtener el valor ingresado en el EditText y convertirlo a un número o usar 0.0 si no es válido
            val sueldoBruto = sueldoBrutoEditText.text.toString().toDoubleOrNull() ?: 0.0
            // Crear una instancia de la clase EmpleadoContrato con el sueldo bruto proporcionado
            val empleado = EmpleadoContrato(sueldoBruto)
            // Calcular el sueldo líquido utilizando el método en la clase EmpleadoContrato
            val sueldoLiquido = empleado.calcularLiquido()
            // Mostrar un mensaje emergente con el sueldo líquido calculado
            Toast.makeText(this, "Sueldo líquido: $sueldoLiquido", Toast.LENGTH_LONG).show()
        }

        // Definir el comportamiento cuando se hace clic en el botón "Volver"
        volverButton.setOnClickListener {
            // Finalizar la actividad actual y regresar a la actividad anterior
            finish()
        }
    }
}