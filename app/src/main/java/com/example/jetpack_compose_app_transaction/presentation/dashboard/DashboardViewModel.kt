package com.example.jetpack_compose_app_transaction.presentation.dashboard

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpack_compose_app_transaction.domain.repository.TransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val repository: TransactionRepository,
) : ViewModel() {
    private val _overViewCardState = mutableStateOf(OverViewCardModel())
    val overViewCardState = _overViewCardState

    private val _recentTransactionListState = mutableStateOf(RecentTransactionListState())
    val recentTransactionListState = _recentTransactionListState

    init {
        viewModelScope.launch {
            repository.getTransactions().collect { transactions ->
                _overViewCardState.value = overViewCardState.value.copy(
                    totalBalance =
                    transactions.filter { transaction -> transaction.transactionType == "income" }
                        .sumOf { it.amount } - transactions.filter { transaction -> transaction.transactionType == "expense" }
                        .sumOf { it.amount },
                    income = transactions.filter { it.transactionType == "income" }.takeLast(2)
                        .sumOf { it.amount },
                    expense = transactions.filter { it.transactionType == "expense" }.takeLast(2)
                        .sumOf { it.amount }
                )
                _recentTransactionListState.value = recentTransactionListState.value.copy(
                    list = transactions.takeLast(4).reversed()
                )
            }
        }
    }
}