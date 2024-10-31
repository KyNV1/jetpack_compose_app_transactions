package com.example.jetpack_compose_app_transaction.presentation.transaction_details

import com.example.jetpack_compose_app_transaction.domain.model.Transaction

data class CurrTransactionState(
    val transaction: Transaction? = Transaction(
        id = -1,
        transactionType = "",
        title = "",
        amount = 0,
        date = "",
        tags = "",
        note = ""
    )
)