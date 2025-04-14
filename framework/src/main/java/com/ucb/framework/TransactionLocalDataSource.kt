package com.ucb.framework

import com.ucb.framework.persistence.AppDatabase
import com.ucb.data.ITransactionLocalDataSource
import com.ucb.domain.Balance
import com.ucb.domain.Expense
import com.ucb.domain.Income
import com.ucb.domain.Transaction
import com.ucb.framework.persistence.entity.ExpenseEntity
import com.ucb.framework.persistence.entity.IncomeEntity
import com.ucb.framework.persistence.entity.BalanceEntity
import com.ucb.framework.mappers.BalanceMapper
import com.ucb.framework.mappers.ExpenseMapper
import com.ucb.framework.mappers.IncomeMapper
import com.ucb.framework.persistence.TransactionDao

class TransactionLocalDataSource(private val appDatabase: AppDatabase, private val expenseMapper: ExpenseMapper, private val incomeMapper: IncomeMapper, private val balanceMapper: BalanceMapper) : ITransactionLocalDataSource {

    override fun saveExpense(expense: Expense) {
        val expenseEntity = ExpenseEntity(
            id = expense.id,
            nombre = expense.nombre,
            precio = expense.precio,
            descripcion = expense.descripcion,
            fecha = expense.fecha,
        )
        appDatabase.transactionDao().saveExpense(expenseEntity)
    }

    override fun saveIncome(income: Income) {
        val incomeEntity = IncomeEntity(
            id = income.id,
            nombre = income.nombre,
            precio = income.precio,
            descripcion = income.descripcion,
            fecha = income.fecha,
        )
        appDatabase.transactionDao().saveIncome(incomeEntity)
    }

    override fun getAllTransactions(): List<Transaction> {
        val expenses = appDatabase.transactionDao().getAllExpense()
        val incomes = appDatabase.transactionDao().getAllIncomes()
        val mappedExpenses = expenses.map { expenseMapper.fromEntity(it) }
        val mappedIncomes = incomes.map { incomeMapper.fromEntity(it) }
        val allTransactions = mappedExpenses + mappedIncomes
        return allTransactions.sortedByDescending { transaction ->
            when (transaction) {
                is Transaction.Income -> transaction.fecha
                is Transaction.Expense -> transaction.fecha
            }
        }
    }

    override fun deleteTransaction(id: String) {
        appDatabase.transactionDao().deleteTransactionById(id)
    }

    override fun getBalance(): Balance {
        val balanceEntity = appDatabase.transactionDao().getBalance() ?: BalanceEntity(totalIncome = 0.0, totalExpenses = 0.0, balance = 0.0)
        return balanceMapper.fromEntity(balanceEntity)
    }
}