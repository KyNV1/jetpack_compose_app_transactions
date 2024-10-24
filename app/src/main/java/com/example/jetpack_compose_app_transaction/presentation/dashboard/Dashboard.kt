package com.example.jetpack_compose_app_transaction.presentation.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jetpack_compose_app_transaction.R
import com.example.jetpack_compose_app_transaction.presentation.common.components.TransactionCard
import com.example.jetpack_compose_app_transaction.utils.Screen

@Composable
fun Dashboard(
    navController: NavController,
    viewModel: DashboardViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
) {
    val recentList by viewModel.recentTransactionListState

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(onClick = {
                navController.navigate(Screen.About.route)
            }) {
                Icon(
                    imageVector = Icons.Default.Info,
                    modifier = Modifier.size(32.dp),
                    contentDescription = null
                )
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Card(
                shape = RoundedCornerShape(16.dp),
                backgroundColor = Color(0XFFD16C97)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = stringResource(R.string.total_balance))
                    Text("$23")
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        SummaryMiniCard(
                            colors = Color(0xFF00CB51),
                            imageVector = Icons.Outlined.KeyboardArrowDown,
                            heading = "income",
                            content = "$24"
                        )

                        SummaryMiniCard(
                            colors = Color(0xFF00CB51),
                            imageVector = Icons.Outlined.KeyboardArrowUp,
                            heading = "income",
                            content = "$24"
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))

            }
            Spacer(modifier = Modifier.height(4.dp))
        }
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp, 16.dp)
        ) {
            Text(text = "Recent Transactions...")
        }
        if (!recentList.list.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "No recent transactions...", color = Color(0xFFD16C97))
            }

        } else {
            LazyColumn(
                contentPadding = PaddingValues(8.dp, 0.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

            }
        }
    }
}

@Composable
fun SummaryMiniCard(
    colors: Color,
    imageVector: ImageVector,
    heading: String,
    content: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(Color(0xFFFAD9E6))
        ) {
            Icon(
                imageVector = imageVector,
                contentDescription = null,
                modifier = Modifier.size(40.dp),
                tint = colors
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = heading, color = Color.White.copy(0.7f), fontSize = 16.sp)
            Text(text = content, color = Color.White)
        }
    }
}

@Preview
@Composable
private fun DashboardPreview() {
    Dashboard(navController = rememberNavController())
}