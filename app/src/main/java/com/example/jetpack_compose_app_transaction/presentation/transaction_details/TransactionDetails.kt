package com.example.jetpack_compose_app_transaction.presentation.transaction_details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun TransactionDetails(
    navHostController: NavHostController,
    modifier: Modifier = Modifier

    ) {
    Column(
        modifier = modifier
            .background(MaterialTheme.colors.primary)
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            IconButton(
                onClick = {
                    navHostController.navigateUp()
                }
            ) {
                Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = "Back to screen")
            }
            Row {
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Transactions", fontSize = 20.sp)
            }
            Row {
                IconButton(
                    onClick = {}
                ) {
                    Icon(imageVector = Icons.Outlined.Delete, contentDescription = "delete item card")
                }
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Outlined.Share, "sharin")
                }
            }

        }
    }
}

@Preview
@Composable
private fun TransactionDetailsPreview() {
    TransactionDetails(navHostController = rememberNavController())
}