package com.example.jetpack_compose_app_transaction.presentation.common.components


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.NorthEast
import androidx.compose.material.icons.outlined.SouthWest
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpack_compose_app_transaction.domain.model.Transaction

@Composable
fun TransactionCard(
    transaction: Transaction,
    modifier: Modifier = Modifier,
    onClickItem:()->Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .clickable {
                onClickItem()
            }
            .background(Color(0xFFD16C97))
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = if (transaction.transactionType == "expense") {
                Icons.Outlined.NorthEast
            } else {
                Icons.Outlined.SouthWest
            },
            modifier = Modifier.size(40.dp),
            tint = Color.White,
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = transaction.title, color = Color.White, fontSize = 16.sp)
                Text(
                    modifier = Modifier.width(64.dp),
                    text = transaction.tags,
                    color = Color.White.copy(0.7f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = if (transaction.transactionType == "Expense") {
                        "-$${transaction.amount}"
                    } else {
                        "+$${transaction.amount}"
                    },
                    color = Color.White,
                    fontSize = 16.sp,
                )

                Text(
                    text = transaction.date,
                    color = Color.White.copy(0.7f),
                )
            }
        }
    }
}
