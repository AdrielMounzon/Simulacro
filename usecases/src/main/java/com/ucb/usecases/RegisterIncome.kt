package com.ucb.usecases

import com.ucb.domain.Income
import com.ucb.data.ITransactionRepository

class RegisterIncome(private val transactionRepository: ITransactionRepository) {
    operator fun invoke(income: Income) {
        transactionRepository.registerIncome(income)
    }
}