package com.ucb.data

import com.ucb.domain.Balance
import com.ucb.domain.Expense
import com.ucb.domain.Income
import com.ucb.domain.Transaction

class TransactionRepository(private val localDataSource: ITransactionLocalDataSource) : ITransactionRepository {
    override fun registerExpense(expense: Expense) {
        localDataSource.saveExpense(expense)
    }

    override fun registerIncome(income: Income) {
        localDataSource.saveIncome(income)
    }

    override fun getAllTransactions(): List<Transaction> {
        return localDataSource.getAllTransactions()
    }

    override fun deleteTransaction(id: String) {
        localDataSource.deleteTransaction(id)
    }
    override fun getBalance(): Balance {
        return localDataSource.getBalance()
    }
}