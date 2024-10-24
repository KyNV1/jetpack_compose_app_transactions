package com.example.jetpack_compose_app_transaction.presentation.add_edit_transaction

data class AddEditTransactionDropDownMenuState(
    val isExpensed: Boolean = false,
    var selectedOption: String = "",
    val hint: String = ""
)