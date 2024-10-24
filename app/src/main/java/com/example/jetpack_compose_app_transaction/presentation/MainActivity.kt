package com.example.jetpack_compose_app_transaction.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Assistant
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jetpack_compose_app_transaction.R
import com.example.jetpack_compose_app_transaction.presentation.abount.AboutScreen
import com.example.jetpack_compose_app_transaction.presentation.add_edit_transaction.AddEditTransaction
import com.example.jetpack_compose_app_transaction.presentation.dashboard.Dashboard
import com.example.jetpack_compose_app_transaction.presentation.transactions.TransactionScreen
import com.example.jetpack_compose_app_transaction.ui.theme.Jetpack_compose_app_transactionTheme
import com.example.jetpack_compose_app_transaction.utils.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Jetpack_compose_app_transactionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SetupNavigation()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SetupNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Scaffold(
        bottomBar = {
            if (currentRoute == Screen.Dashboard.route || currentRoute == Screen.Transaction.route) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    BottomBar(navController = navController)
                    Column {
                        FloatingActionButton(onClick = {
                            navController.navigate(Screen.AddEditTransaction.route)
                        }) {
                            Icon(
                                imageVector = Icons.Outlined.Add,
                                contentDescription = "Add transaction",
                                tint = Color.White
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                    }

                }
            }

        },
        modifier = modifier
            .systemBarsPadding()
            .fillMaxSize()
    ) {
        NavigationGraph(navController = navController)
    }


}

@Composable
fun BottomBar(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    BottomNavigation(
        backgroundColor = Color(0xFFE4AEC5)
    ) {
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = stringResource(R.string.dashboard)
                )
            },
            label = {
                Text(text = "Doashboard")
            },
            selectedContentColor = Color(0xFFE4AEC5),
            unselectedContentColor = Color.White,
            alwaysShowLabel = false,
            selected = currentRoute == Screen.Dashboard.route,
            onClick = {
                navController.navigate(Screen.Dashboard.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        )

        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Assistant,
                    contentDescription = stringResource(R.string.transactions)
                )
            },
            label = {
                Text(text = "Transactions")
            },
            alwaysShowLabel = false,
            selectedContentColor = Color(0xFFE4AEC5),
            unselectedContentColor = Color.White,
            selected = currentRoute == Screen.Transaction.route,
            onClick = {
                navController.navigate(Screen.Transaction.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        )
    }
}

@Preview
@Composable
private fun BottomBarPreview() {
    BottomBar(navController = rememberNavController())
}

@Composable
fun NavigationGraph(
    navController: NavHostController
) {

    NavHost(navController = navController, startDestination = Screen.Dashboard.route) {
        composable(route = Screen.Dashboard.route) {
            Dashboard(navController = navController)
        }
        composable(route = Screen.About.route) {
            AboutScreen()
        }
        composable(route = Screen.AddEditTransaction.route) {
            AddEditTransaction()
        }
        composable(route = Screen.Transaction.route) {
            TransactionScreen()
        }


    }

}

