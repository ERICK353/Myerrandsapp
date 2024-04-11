package com.example.myapplication.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.Components.Buttoncomponent
import com.example.myapplication.Components.ClickacleSignupTextcomponent
import com.example.myapplication.Components.Dividertextcomponent
import com.example.myapplication.Components.HeadingtextComponents
import com.example.myapplication.Components.MyTextInput
import com.example.myapplication.Components.UnderlinedtextComponents
import com.example.myapplication.ErrandAppRouter
import com.example.myapplication.LogInVeiwModel
import com.example.myapplication.R
import com.example.myapplication.Screen
import com.example.myapplication.data.LogInUIEvent
import com.example.myapplication.data.SignUpViewModel

@Composable
fun LoginScreen(logInVeiwModel:LogInVeiwModel= viewModel()) {


    Box(modifier=Modifier
        .fillMaxSize(),
        contentAlignment= Alignment.Center) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(28.dp)

        )


        {
            val scrollState = rememberScrollState()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
            ) {

                HeadingtextComponents(value = stringResource(id = R.string.login))
                Spacer(modifier = Modifier.height(50.dp))
                MyTextInput(
                    labelValue = stringResource(id = R.string.Email),
                    painterResource = painterResource(id = R.drawable.email),
                    onTextSelected = {
                        logInVeiwModel.OnEvent(LogInUIEvent.EmailChanged(it))
                    },
                    errorStatus = logInVeiwModel.loginuistate.value.emailError
                )
                MyTextInput(
                    labelValue = stringResource(id = R.string.Password),
                    painterResource = painterResource(id = R.drawable.baseline_password_24),
                    onTextSelected = {
                        logInVeiwModel.OnEvent(LogInUIEvent.PasswordChanged(it))
                    },
                    errorStatus = logInVeiwModel.loginuistate.value.passwordError
                )


                Spacer(modifier = Modifier.height(10.dp))
                Buttoncomponent(
                    value = stringResource(id = R.string.login), onButtonClicked = {
                        logInVeiwModel.OnEvent(LogInUIEvent.LoginButtonClicked)


                    }, isEnabled = logInVeiwModel.allValidationsPassed.value
                )
                Spacer(modifier = Modifier.height(20.dp))
                UnderlinedtextComponents(value = stringResource(id = R.string.forgotpassword))

                Dividertextcomponent()
                ClickacleSignupTextcomponent(Tryingtologin = true, onTextSelected = {
                    ErrandAppRouter.navigateTo(Screen.SignUpScreen)

                })


            }

            }
        if (logInVeiwModel.loginInProgress.value) {
            CircularProgressIndicator()
        }
        }



    }



@Preview
@Composable
fun Previewloginscreen(){
    LoginScreen()
}