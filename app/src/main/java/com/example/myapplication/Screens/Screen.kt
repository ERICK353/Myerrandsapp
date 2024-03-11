package com.example.myapplication.Screens
sealed class Screen(val route:String) {
    object SIGNUP : Screen(route = "SIGNUP_SCREEN")
    object LOGIN: Screen(route = "LOGIN_SCREEN")
    object TERMS : Screen(route = "TERMS_SCREEN")
    object DASHBOARD: Screen(route = "DASHBOARD_SCREEN")
}