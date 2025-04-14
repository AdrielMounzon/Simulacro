package com.ucb.usecases

import com.ucb.domain.Transaction
import com.ucb.data.ITransactionRepository

class ListTransactions(private val transactionRepository: ITransactionRepository) {
    operator fun invoke(): List<Transaction> {
        return transactionRepository.getAllTransactions().sortedByDescending {
            when(it){
                is Transaction.Expense -> it.fecha
                is Transaction.Income -> it.fecha
            }
        }
    }
}