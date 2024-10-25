package com.example.jetpack_compose_app_transaction.presentation.transaction_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpack_compose_app_transaction.domain.repository.TransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionDetailsViewModel  @Inject constructor(
    private val repository: TransactionRepository
):ViewModel(){
    init {
        viewModelScope.launch {

        }
    }
}