package com.ucb.framework.persistence.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class ExpenseEntity(
    val nombre: String,
    val precio: Double,
    val descripcion: String,
    val fecha: Date,
    @PrimaryKey val id: String
)