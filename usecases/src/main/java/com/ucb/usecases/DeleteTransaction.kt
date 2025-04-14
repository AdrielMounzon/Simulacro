package com.ucb.usecases

import com.ucb.data.ITransactionRepository

class DeleteTransaction(private val transactionRepository: ITransactionRepository) {
    operator fun invoke(id: String) {
        transactionRepository.deleteTransaction(id)
    }
}