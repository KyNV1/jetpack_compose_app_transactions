package com.example.jetpack_compose_app_transaction.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Transaction(
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    val title:String,
    val amount:Long,
    val transactionType:String,
    val tags:String,
    val date:String,
    val note:String
)