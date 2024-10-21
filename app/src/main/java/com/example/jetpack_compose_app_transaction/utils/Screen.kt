package com.example.jetpack_compose_app_transaction.utils

sealed class Screen(val route:String) {
    object Dashboard: Screen("dash_screen")
    object About:Screen("about_screen")
    object Transaction:Screen("transaction")
}