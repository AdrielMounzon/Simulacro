package com.ucb.usecases

import com.ucb.domain.Expense
import com.ucb.data.ITransactionRepository

class RegisterExpense(private val transactionRepository: ITransactionRepository) {
    operator fun invoke(expense: Expense) {
        transactionRepository.registerExpense(expense)
    }
}