package com.ucb.framework.mappers

import com.ucb.domain.Transaction
import com.ucb.framework.persistence.entity.ExpenseEntity

class ExpenseMapper {
    fun fromEntity(expenseEntity: ExpenseEntity): Transaction.Expense {
        return Transaction.Expense(
            id = expenseEntity.id,
            nombre = expenseEntity.nombre,
            precio = expenseEntity.precio,
            descripcion = expenseEntity.descripcion,
            fecha = expenseEntity.fecha
        )
    }
}