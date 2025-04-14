package com.ucb.framework.mappers

import com.ucb.domain.Transaction
import com.ucb.framework.persistence.entity.IncomeEntity

class IncomeMapper {
    fun fromEntity(incomeEntity: IncomeEntity): Transaction.Income {
        return Transaction.Income(
            nombre = incomeEntity.nombre,
            precio = incomeEntity.precio,
            descripcion = incomeEntity.descripcion,
            fecha = incomeEntity.fecha,
            id = incomeEntity.id
        )
    }
}