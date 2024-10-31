package com.example.jetpack_compose_app_transaction.presentation.transaction_details

import androidx.navigation.NavController
import androidx.navigation.NavHostController

sealed class TransactionDetailEvent {
    data class onDeleteTranaction(val id: Int, val navController: NavController) :
        TransactionDetailEvent()
}