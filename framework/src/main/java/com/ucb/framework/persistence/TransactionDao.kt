package com.ucb.framework.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ucb.framework.persistence.entity.BalanceEntity
import com.ucb.framework.persistence.entity.ExpenseEntity
import com.ucb.framework.persistence.entity.IncomeEntity

@Dao
interface TransactionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveExpense(expense: ExpenseEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveIncome(income: IncomeEntity)

    @Query("SELECT * FROM ExpenseEntity")
    fun getAllExpense(): List<ExpenseEntity>

    @Query("SELECT * FROM IncomeEntity")
    fun getAllIncomes(): List<IncomeEntity>

    @Query("DELETE FROM ExpenseEntity WHERE id = :id")
    fun deleteExpenseById(id: String)

    @Query("DELETE FROM IncomeEntity WHERE id = :id")
    fun deleteIncomeById(id: String)

    @Query("SELECT * FROM BalanceEntity LIMIT 1")
    fun deleteTransactionById(id: String){
        deleteExpenseById(id)
        deleteIncomeById(id)
    }

    @Query("SELECT * FROM BalanceEntity LIMIT 1")
    fun getBalance(): BalanceEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveBalance(balance: BalanceEntity)
}