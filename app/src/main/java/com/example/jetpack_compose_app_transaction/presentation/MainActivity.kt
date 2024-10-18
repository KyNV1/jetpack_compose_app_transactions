package com.example.jetpack_compose_app_transaction.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpack_compose_app_transaction.presentation.abount.AboutScreen
import com.example.jetpack_compose_app_transaction.presentation.dashboard.Dashboard
import com.example.jetpack_compose_app_transaction.ui.theme.Jetpack_compose_app_transactionTheme
import com.example.jetpack_compose_app_transaction.utils.Screen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Jetpack_compose_app_transactionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {  innerPadding ->
                    SetupNavigation()
                }
            }
        }
    }
}

@Composable
fun SetupNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Dashboard.route){
        composable(route = Screen.Dashboard.route){
            Dashboard()
        }
        composable(route = Screen.About.route){
            AboutScreen()
        }
    }
}

