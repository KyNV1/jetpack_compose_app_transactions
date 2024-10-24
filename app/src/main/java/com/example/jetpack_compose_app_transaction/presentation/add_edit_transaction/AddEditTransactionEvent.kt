package com.example.jetpack_compose_app_transaction.presentation.add_edit_transaction

import android.content.Context
import androidx.navigation.NavHostController

sealed class AddEditTransactionEvent {
    data class EnteredTitle(val value: String) : AddEditTransactionEvent()
    data class EnteredAmount(val value: String) : AddEditTransactionEvent()
    data class EnterTags(val value: String) : AddEditTransactionEvent()
    data class EnterNote(val value: String) : AddEditTransactionEvent()
    object OnExpandedChange : AddEditTransactionEvent()
    object OnDismissRequest : AddEditTransactionEvent()
    data class ChangeSelectedOption(val value: String) : AddEditTransactionEvent()
    data class SaveEditTransaction(val context: Context, val navHostController: NavHostController):AddEditTransactionEvent()
}