package com.ucb.framework.persistence.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BalanceEntity(
    val totalIncome: Double,
    val totalExpenses: Double,
    val balance: Double
)