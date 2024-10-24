package com.example.jetpack_compose_app_transaction.presentation.dashboard

import com.example.jetpack_compose_app_transaction.domain.model.Transaction

data class RecentTransactionListState(
    val list:List<Transaction> = mutableListOf()
)