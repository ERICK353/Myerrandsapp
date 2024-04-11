package com.example.myapplication.data

sealed class LogInUIEvent {

    data class EmailChanged(val Email:String): LogInUIEvent()
    data class PasswordChanged(val Password:String): LogInUIEvent()

object LoginButtonClicked: LogInUIEvent()

}