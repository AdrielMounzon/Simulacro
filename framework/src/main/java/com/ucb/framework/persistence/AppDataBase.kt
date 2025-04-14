package com.ucb.framework.persistence

import android.content.Context
import androidx.room.Room
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ucb.framework.persistence.entity.BalanceEntity
import com.ucb.framework.persistence.entity.ExpenseEntity
import com.ucb.framework.persistence.entity.IncomeEntity
import com.ucb.framework.util.DateConverter

@Database(entities = [ExpenseEntity::class, IncomeEntity::class, BalanceEntity::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun transactionDao(): TransactionDao


    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}