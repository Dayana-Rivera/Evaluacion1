package com.example.proyecto12

abstract class Empleado(protected val sueldoBruto: Double) {
    abstract fun calcularLiquido(): Double
}