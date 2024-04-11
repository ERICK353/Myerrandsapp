package com.example.myapplication.data

sealed class SignUpUIEvent {
    data class FirstnameChanged(val firstName:String):SignUpUIEvent()
    data class LastnameChanged(val lastName:String):SignUpUIEvent()
    data class EmailChanged(val Email:String):SignUpUIEvent()
    data class PasswordChanged(val Password:String):SignUpUIEvent()
    data class TermsCheckboxClicked(val status:Boolean):SignUpUIEvent()
object RegisterButtonClicked:SignUpUIEvent()

}