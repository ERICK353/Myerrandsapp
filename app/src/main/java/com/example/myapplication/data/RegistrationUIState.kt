package com.example.myapplication.data

data class RegistrationUIState(
    var firstname:String="",
    var lastname:String="",
    var email:String="",
    var password:String="",
    var termsAccepted:Boolean=false,


    var firstNameError:Boolean=false,
    var lastNameError:Boolean=false,
    var emailError:Boolean=false,
    var passwordError:Boolean=false,
    var termsError:Boolean=false,


)