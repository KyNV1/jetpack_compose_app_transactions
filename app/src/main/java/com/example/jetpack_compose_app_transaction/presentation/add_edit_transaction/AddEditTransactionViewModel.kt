package com.example.jetpack_compose_app_transaction.presentation.add_edit_transaction

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpack_compose_app_transaction.domain.model.Transaction
import com.example.jetpack_compose_app_transaction.domain.repository.TransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
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
    val amount: State<AddEditTransactionTextFieldState> = _amount

    private val _tags = mutableStateOf(
        AddEditTransactionTextFieldState(
            hint = "Tags"
        )
    )
    val tags: State<AddEditTransactionTextFieldState> = _tags

    private val _notes = mutableStateOf(
        AddEditTransactionTextFieldState(
            hint = "Type a Note..."
        )
    )
    val note: State<AddEditTransactionTextFieldState> = _notes

    private val _transactionType = mutableStateOf(
        AddEditTransactionDropDownMenuState(
            hint = "Selection..."
        )
    )
    val transactionType: State<AddEditTransactionDropDownMenuState> = _transactionType

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

            is AddEditTransactionEvent.EnterTags -> {
                _tags.value = tags.value.copy(
                    text = event.value
                )
            }

            is AddEditTransactionEvent.EnterNote -> {
                _notes.value = note.value.copy(
                    text = event.value
                )
            }

            is AddEditTransactionEvent.ChangeSelectedOption -> {
                _transactionType.value = transactionType.value.copy(
                    selectedOption = event.value
                )
            }

            AddEditTransactionEvent.OnDismissRequest -> {
                _transactionType.value = transactionType.value.copy(
                    isExpensed = false
                )
            }

            AddEditTransactionEvent.OnExpandedChange -> {
                _transactionType.value = transactionType.value.copy(
                    isExpensed = !transactionType.value.isExpensed
                )
            }

            is AddEditTransactionEvent.SaveEditTransaction -> {
                if (
                    title.value.text != "" || amount.value.text != "" ||
                    transactionType.value.selectedOption != "" ||
                    tags.value.text != "" || note.value.text != ""
                ) {
                    viewModelScope.launch {
                        repository.insertTransaction(
                            Transaction(
                                title = title.value.text,
                                amount = amount.value.text.toLong(),
                                transactionType = transactionType.value.selectedOption,
                                tags = tags.value.text,
                                date = getFormattedTime(),
                                note = note.value.text
                            )
                        )
                    }
                    event.navHostController.navigateUp()
                } else {
                    Toast.makeText(
                        event.context,
                        "Please fill all the fields",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}