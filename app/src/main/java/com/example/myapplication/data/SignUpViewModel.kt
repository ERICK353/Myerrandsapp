package com.example.myapplication.data

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.myapplication.ErrandAppRouter
import com.example.myapplication.Screens.AddErrandScreen
import com.example.myapplication.data.rules.Validator
import com.google.firebase.auth.FirebaseAuth

class SignUpViewModel: ViewModel() {
     lateinit var navController:NavController
    private val TAG=SignUpViewModel::class.simpleName
    var registrationUIState= mutableStateOf(RegistrationUIState())
    var AllValidationPassed= mutableStateOf(false)
    var signUpInProgress= mutableStateOf(false)
    fun onEvent(event:SignUpUIEvent){
        validateDataWithRules()
        when(event){
            is SignUpUIEvent.FirstnameChanged->{
           registrationUIState.value=registrationUIState.value.copy(
               firstname = event.firstName
           )
                printState()
            }
            is SignUpUIEvent.LastnameChanged->{
                registrationUIState.value=registrationUIState.value.copy(
                    lastname = event.lastName
                )
                printState()
            }
            is SignUpUIEvent.EmailChanged->{
                registrationUIState.value=registrationUIState.value.copy(
                    email =event.Email
                )
                printState()
            }
            is SignUpUIEvent.PasswordChanged->{
                registrationUIState.value=registrationUIState.value.copy(
                    password = event.Password
                )
                printState()
            }
            is SignUpUIEvent.RegisterButtonClicked -> {
                signUp()
            }
            is SignUpUIEvent.TermsCheckboxClicked -> {
                registrationUIState.value=registrationUIState.value.copy(
                    termsAccepted = event.status
                )
            }
        }
    }
    private fun signUp(){
        Log.d(TAG,"Inside Signup")
        printState()
        createUserInFirebase(
            email=registrationUIState.value.email,
            password=registrationUIState.value.password,
        )
    }
    private fun validateDataWithRules(){
        val fNameResult=Validator.validateFirstName(
            fName = registrationUIState.value.firstname
        )
        val lNameResult=Validator.validateLastName(
            lName = registrationUIState.value.lastname
        )
        val emailResult=Validator.validateEmail(
            email = registrationUIState.value.email
        )
        val passWordResult=Validator.validatePassword(
           password = registrationUIState.value.password
        )
        val termsResult=Validator.validateTerms(
            statusValue= registrationUIState.value.termsAccepted
        )
        Log.d(TAG,"Inside validatedatawithrules")
        Log.d(TAG,"fNmaeResult=$fNameResult")
        Log.d(TAG,"lNameResult=$lNameResult")
        Log.d(TAG,"emailresult=$emailResult")
        Log.d(TAG,"password=$passWordResult")
        Log.d(TAG,"terms=$termsResult")
        registrationUIState.value=registrationUIState.value.copy(
            firstNameError = fNameResult.status,
            lastNameError = lNameResult.status,
            emailError = emailResult.status,
            passwordError=passWordResult.status,
            termsError = termsResult.status
        )
        if(fNameResult.status && lNameResult.status&&emailResult.status&&passWordResult.status&&termsResult.status){
            AllValidationPassed.value=true
        }
        else{
            AllValidationPassed.value=false
        }
    }
    private fun printState(){
        Log.d(TAG,"Inside printstate")
        Log.d(TAG,registrationUIState.value.toString())
    }



    private fun createUserInFirebase(email:String,password:String){
        signUpInProgress.value=true
     FirebaseAuth.getInstance()
         .createUserWithEmailAndPassword(email,password)
         .addOnCompleteListener {
             Log.d(TAG,"isSuccesful=${it.isSuccessful}")
             Log.d(TAG,"isSuccesful=${it.isSuccessful}")
            signUpInProgress.value=false
             if(it.isSuccessful){
                 ErrandAppRouter.navigateTo(com.example.myapplication.Screen.LoginScreen)
             }
         }
         .addOnFailureListener {
             Log.d(TAG,"Failed=${it.message}")
             Log.d(TAG,"Failed=${it.localizedMessage}")
         }

 }
    fun logout(){

    }
}