package com.example.jetpack_compose_app_transaction.domain.repository

import com.example.jetpack_compose_app_transaction.domain.model.Transaction
import kotlinx.coroutines.flow.Flow

interface TransactionRepository{
    suspend fun insertTransaction(transaction: Transaction)
    suspend fun updateTransaction(transaction: Transaction)
    suspend fun getTransactions(): Flow<List<Transaction>>
    suspend fun deleteTransaction(transaction: Transaction)
    suspend fun getTransactionById(id:Int):Flow<Transaction>
}