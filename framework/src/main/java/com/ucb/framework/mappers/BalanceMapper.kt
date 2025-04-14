package com.ucb.framework.mappers

import com.ucb.domain.Balance
import com.ucb.framework.persistence.entity.BalanceEntity

class BalanceMapper {
    fun fromEntity(balanceEntity: BalanceEntity): Balance {
        return Balance(
            totalIncome = balanceEntity.totalIncome,
            totalExpenses = balanceEntity.totalExpenses,
            balance = balanceEntity.balance
        )
    }
}