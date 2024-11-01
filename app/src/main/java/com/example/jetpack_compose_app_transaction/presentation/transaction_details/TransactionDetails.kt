package com.example.jetpack_compose_app_transaction.presentation.transaction_details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jetpack_compose_app_transaction.utils.Screen

@Composable
fun TransactionDetails(
    navController: NavController,
    viewModel: TransactionDetailsViewModel = hiltViewModel(),
    transactionId: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(MaterialTheme.colors.primary)
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {
                    navController.navigateUp()
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
                    onClick = {
                        viewModel.onEvent(TransactionDetailEvent.onDeleteTranaction(id = transactionId, navController = navController))
                    }
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Delete,
                        contentDescription = "delete item card"
                    )
                }
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Outlined.Share, "sharin")
                }
            }

        }
        Spacer(modifier = Modifier.height(24.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 0.dp)
        ) {
            Box {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .background(color = Color(0XFFD16C97))
                        .padding(24.dp, 32.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Spacer(modifier = Modifier.height(24.dp))
                    Column {
                        Text(text = "Title", color = Color.White.copy(0.7f))
                        viewModel.currTransactionState.value.transaction?.let {
                            Text(text = it.title, color = Color.White)
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Column {
                        Text(text = "Amount", color = Color.White.copy(0.7f))
                        viewModel.currTransactionState.value.transaction?.let {
                            Text(text = it.amount.toString(), color = Color.White)
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Column {
                        Text(text = "TransactionType", color = Color.White.copy(0.7f))
                        viewModel.currTransactionState.value.transaction?.let {
                            Text(text = it.transactionType, color = Color.White)
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Column {
                        Text(text = "When",color = Color.White.copy(0.7f))
                        viewModel.currTransactionState.value.transaction?.let {
                            Text(text = it.date,color = Color.White)
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Column {
                        Text(text = "Note",color = Color.White.copy(0.7f))
                        viewModel.currTransactionState.value.transaction?.let {
                            Text(text = it.note, color = Color.White)
                        }
                    }

                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.End

                ) {
                    IconButton(onClick = {
                        navController.navigate(Screen.AddEditTransaction.route + "/${transactionId}" + "/${Screen.TransactionDetails.route}")
                    }) {
                        Icon(
                            imageVector = Icons.Outlined.Edit,
                            contentDescription = "edit transaction",
                            tint = Color.White
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun TransactionDetailsPreview() {
}