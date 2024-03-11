package com.example.myapplication.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.Components.Buttoncomponent
import com.example.myapplication.Components.ClickacleSignupTextcomponent
import com.example.myapplication.Components.Dividertextcomponent
import com.example.myapplication.Components.HeadingtextComponents
import com.example.myapplication.Components.MyTextInput
import com.example.myapplication.Components.UnderlinedtextComponents
import com.example.myapplication.ErrandAppRouter
import com.example.myapplication.R
import com.example.myapplication.Screen
import com.example.myapplication.data.LoginViewModel

@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel()) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    )

    {
        val scrollState= rememberScrollState()
        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)) {

            HeadingtextComponents(value = stringResource(id = R.string.login))
            Spacer(modifier = Modifier.height(50.dp))
            MyTextInput(
                labelValue = stringResource(id = R.string.Email),
                painterResource = painterResource(id = R.drawable.email),
                onTextSelected = {

                },
                errorStatus = loginViewModel.registrationUIState.value.emailError
            )
            MyTextInput(
                labelValue = stringResource(id = R.string.Password),
                painterResource = painterResource(id = R.drawable.email),
                onTextSelected = {

                },
                errorStatus = loginViewModel.registrationUIState.value.passwordError
            )


            Spacer(modifier = Modifier.height(10.dp))
            Buttoncomponent(value = stringResource(id = R.string.login), onButtonClicked = {})
            Spacer(modifier = Modifier.height(20.dp))
            UnderlinedtextComponents(value = stringResource(id = R.string.forgotpassword))

            Dividertextcomponent()
            ClickacleSignupTextcomponent(Tryingtologin = true, onTextSelected = {
ErrandAppRouter.navigateTo(Screen.DashBoardScreen)

            })
        }

    }
}


@Preview
@Composable
fun Previewloginscreen(){
    LoginScreen()
}