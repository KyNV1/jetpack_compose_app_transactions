package com.example.jetpack_compose_app_transaction.presentation.add_edit_transaction

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


fun getFormattedTime():String{
    val currentDateTime = Calendar.getInstance().time
    val formatter = SimpleDateFormat("MM d, yyyy, hh:mm a",Locale.getDefault())
    return formatter.format(currentDateTime)
}