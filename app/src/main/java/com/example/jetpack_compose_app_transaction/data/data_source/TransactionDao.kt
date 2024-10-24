package com.example.jetpack_compose_app_transaction.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.jetpack_compose_app_transaction.domain.model.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transaction: Transaction)

    @Update
    suspend fun updateTransaction(transaction: Transaction)

    @Query("SELECT * FROM `TRANSACTION`")
    suspend fun getTransactions():Flow<List<Transaction>>

    @Delete
    suspend fun deleteTransaction(transaction: Transaction)



}