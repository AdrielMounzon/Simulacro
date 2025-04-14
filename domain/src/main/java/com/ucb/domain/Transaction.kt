package com.ucb.domain

import java.util.Date

sealed class Transaction {
    data class Income(
        val nombre: String,
        val precio: Double,
        val descripcion: String,
        val fecha: Date,
        val id: String
    ) : Transaction()

    data class Expense(
        val nombre: String,
        val precio: Double,
        val descripcion: String,
        val fecha: Date,
        val id: String
    ) : Transaction()
}