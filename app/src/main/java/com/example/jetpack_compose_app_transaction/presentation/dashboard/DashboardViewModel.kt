package com.example.jetpack_compose_app_transaction.presentation.dashboard

import androidx.lifecycle.ViewModel
import com.example.jetpack_compose_app_transaction.domain.repository.TransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val transactionRepository: TransactionRepository
):ViewModel(){

}