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
    fun getAllTransactions():Flow<List<Transaction>>

    @Query("DELETE FROM `TRANSACTION` WHERE id=:id")
    suspend fun deleteTransactionById(id:Int)

    @Query("SELECT * FROM `Transaction` where id=:id")
    fun getTransactionById(id:Int):Flow<Transaction>
}