package com.example.jetpack_compose_app_transaction.data.repository

import com.example.jetpack_compose_app_transaction.data.data_source.TransactionDao
import com.example.jetpack_compose_app_transaction.domain.model.Transaction
import com.example.jetpack_compose_app_transaction.domain.repository.TransactionRepository

class TransactionRepositoryImpl(
    private val dao: TransactionDao
) : TransactionRepository {
    override suspend fun insertTransaction(transaction: Transaction) {
        dao.insertTransaction(transaction)
    }

    override suspend fun updateTransaction(transaction: Transaction) {
        dao.updateTransaction(transaction)
    }

    override suspend fun getTransactions(): List<Transaction> {
        return dao.getTransactions()
    }

    override suspend fun deleteTransaction(transaction: Transaction) {
        dao.deleteTransaction(transaction)
    }


}