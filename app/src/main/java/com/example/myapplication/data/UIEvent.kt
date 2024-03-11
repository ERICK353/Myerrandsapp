package com.example.myapplication.data

sealed class UIEvent {
    data class FirstnameChanged(val firstName:String):UIEvent()
    data class LastnameChanged(val lastName:String):UIEvent()
    data class EmailChanged(val Email:String):UIEvent()
    data class PasswordChanged(val Password:String):UIEvent()
    data class TermsCheckboxClicked(val status:Boolean):UIEvent()
object RegisterButtonClicked:UIEvent()

}