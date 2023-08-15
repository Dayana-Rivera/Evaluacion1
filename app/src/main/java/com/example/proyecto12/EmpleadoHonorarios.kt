package com.example.proyecto12

class EmpleadoHonorarios(sueldoBruto: Double) : Empleado(sueldoBruto) {
    // Definir el porcentaje de retención para el cálculo del sueldo líquido en empleados de honorarios
    private val PORCENTAJE_RETENCION = 0.13

    // Sobreescribir el método calcularLiquido() heredado de la clase Empleado
    override fun calcularLiquido(): Double {
        // Calcular el sueldo líquido restando la retención del sueldo bruto
        return sueldoBruto * (1 - PORCENTAJE_RETENCION)
    }
}