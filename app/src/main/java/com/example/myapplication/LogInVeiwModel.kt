package com.example.myapplication

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.LogInUIEvent
import com.example.myapplication.data.LoginUIState
import com.example.myapplication.data.SignUpViewModel
import com.example.myapplication.data.rules.Validator
import com.google.firebase.auth.FirebaseAuth


class LogInVeiwModel:ViewModel() {
    private val TAG=LogInVeiwModel::class.simpleName
    var loginuistate= mutableStateOf(LoginUIState())
    var allValidationsPassed= mutableStateOf(false)
    var loginInProgress= mutableStateOf(false)


    fun OnEvent(event:LogInUIEvent){
        when    (event){
            is LogInUIEvent.EmailChanged ->{
                loginuistate.value=loginuistate.value.copy(
                    email =event.Email
                )
            }
            is LogInUIEvent.PasswordChanged ->{
                loginuistate.value=loginuistate.value.copy(
                    password = event.Password
                )
            }
            is LogInUIEvent.LoginButtonClicked->{
login()
            }
        }
        validateLoginDataWithRules()
    }


    private fun validateLoginDataWithRules(){
        val emailResult= Validator.validateEmail(
            email = loginuistate.value.email
        )
        val passWordResult= Validator.validatePassword(
            password = loginuistate.value.password
        )
loginuistate.value=loginuistate.value.copy(
    emailError = emailResult.status,
    passwordError =passWordResult.status

)
allValidationsPassed.value=emailResult.status && passWordResult.status

    }

    private fun login() {

        loginInProgress.value=true
        val email=loginuistate.value.email
        val password=loginuistate.value.password

       val firebase= FirebaseAuth.getInstance()
            .signInWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                loginInProgress.value=false
                if(it.isSuccessful)
                    ErrandAppRouter.navigateTo(Screen.DashBoardScreen)

            }
            .addOnFailureListener {
                Log.d(TAG,"ERROR OCURRED")
                Log.d(TAG,"${it.localizedMessage}")
            }

    }



}
