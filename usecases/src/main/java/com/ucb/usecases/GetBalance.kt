package com.ucb.usecases

import com.ucb.domain.Balance
import com.ucb.data.ITransactionRepository

class GetBalance(private val transactionRepository: ITransactionRepository) {
    operator fun invoke(): Balance {
        return transactionRepository.getBalance()
    }
}