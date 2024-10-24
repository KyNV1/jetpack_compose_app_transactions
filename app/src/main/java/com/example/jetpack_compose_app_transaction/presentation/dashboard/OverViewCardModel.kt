package com.example.jetpack_compose_app_transaction.presentation.dashboard

data class OverViewCardModel(
    val totalBalance: Long? = 0,
    val income: Long? = 0,
    val expense: Long? = 0
)