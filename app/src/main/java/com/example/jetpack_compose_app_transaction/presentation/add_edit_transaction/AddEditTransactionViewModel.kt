package com.example.jetpack_compose_app_transaction.presentation.add_edit_transaction

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.jetpack_compose_app_transaction.domain.repository.TransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddEditTransactionViewModel @Inject constructor(
    private val repository: TransactionRepository
) : ViewModel() {
    private val _title = mutableStateOf(
        AddEditTransactionTextFieldState(
            hint = "Enter a Title...."
        )
    )
    val title: State<AddEditTransactionTextFieldState> = _title

    private val _amount = mutableStateOf(
        AddEditTransactionTextFieldState(
            hint = "Enter a Amount..."
        )
    )
    val amount:State<AddEditTransactionTextFieldState> = _amount

    fun onEvent(event: AddEditTransactionEvent) {
        when (event) {
            is AddEditTransactionEvent.EnteredTitle -> {
                _title.value = title.value.copy(
                    text = event.value
                )
            }

            is AddEditTransactionEvent.EnteredAmount -> {
                _amount.value = amount.value.copy(
                    text = event.value
                )
            }
        }
    }
}