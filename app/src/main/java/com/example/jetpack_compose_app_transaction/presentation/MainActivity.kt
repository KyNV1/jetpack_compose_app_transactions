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
import com.example.jetpack_compose_app_transaction.presentation.abount.AboutScreen
import com.example.jetpack_compose_app_transaction.ui.theme.Jetpack_compose_app_transactionTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Jetpack_compose_app_transactionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {  innerPadding ->
                    AboutScreen()
                }
            }
        }
    }
}

@Composable
fun SetupNavigation(modifier: Modifier = Modifier) {

}

