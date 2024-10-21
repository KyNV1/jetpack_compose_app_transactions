package com.example.jetpack_compose_app_transaction.domain.repository

import com.example.jetpack_compose_app_transaction.domain.model.Transaction

interface TransactionRepository{
    suspend fun insertTransaction(transaction: Transaction)
    suspend fun updateTransaction(transaction: Transaction)
    suspend fun getTransactions():List<Transaction>
    suspend fun deleteTransaction(transaction: Transaction)

}