package com.example.jetpack_compose_app_transaction.presentation.transaction_details

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.jetpack_compose_app_transaction.domain.repository.TransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionDetailsViewModel @Inject constructor(
    private val repository: TransactionRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val transactionId: Int = checkNotNull(savedStateHandle["transactionId"])
    private val _currentTransaction = mutableStateOf(CurrTransactionState())
    val currTransactionState: State<CurrTransactionState> = _currentTransaction

    init {
        viewModelScope.launch {
            repository.getTransactionById(transactionId).collect { transaction ->
                _currentTransaction.value = currTransactionState.value.copy(
                    transaction = transaction
                )
            }
        }
    }

    fun onEvent(event: TransactionDetailEvent) {
        when (event) {
            is TransactionDetailEvent.onDeleteTranaction -> {
                viewModelScope.launch {
                    currTransactionState.value.transaction?.let {
                        repository.deleteTransactionById(transactionId)
                    }
                }
                event.navController.navigateUp()
            }
        }
    }
}