package com.example.jetpack_compose_app_transaction.presentation.add_edit_transaction

sealed class AddEditTransactionEvent {
    data class EnteredTitle(val value:String):AddEditTransactionEvent()
    data class EnteredAmount(val value:String):AddEditTransactionEvent()
}