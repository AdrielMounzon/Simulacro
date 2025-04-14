package com.ucb.domain

import java.util.Date

data class Expense(
    val nombre: String,
    val precio: Double,
    val descripcion: String,
    val fecha: Date,
    val id: String
)