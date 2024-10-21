package com.example.jetpack_compose_app_transaction.presentation.dashboard

import com.example.jetpack_compose_app_transaction.domain.model.Transaction
import com.example.jetpack_compose_app_transaction.presentation.add_edit_transaction.getFormattedTime

//data class RecentTransactionListState(
//    val list:List<Transaction> = mutableListOf()
//)

val dummyRecentTransactionListState = listOf(
    Transaction(
        id = 0,
        title = "mi chinh",
        amount = 10L,
        transactionType = "income",
        tags = "kynv1",
        date = getFormattedTime(),
        note = "ptit"
    )
)