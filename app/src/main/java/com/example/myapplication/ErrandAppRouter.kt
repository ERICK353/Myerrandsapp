package com.example.myapplication

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen{
     object SignUpScreen:Screen()
     object TermsandConditions:Screen()
    object LoginScreen:Screen()
    object DashBoardScreen:Screen()
}
object ErrandAppRouter {
    var currentscreen:MutableState<Screen> =mutableStateOf(Screen.LoginScreen)


    fun navigateTo(destination:Screen){
        currentscreen.value=destination
    }

}