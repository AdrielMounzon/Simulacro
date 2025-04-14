package com.ucb.data

import com.ucb.domain.Balance
import com.ucb.domain.Expense
import com.ucb.domain.Income
import com.ucb.domain.Transaction

interface ITransactionLocalDataSource {
    fun saveExpense(expense: Expense)
    fun saveIncome(income: Income)
    fun getAllTransactions(): List<Transaction>
    fun deleteTransaction(id: String)
    fun getBalance(): Balance
}