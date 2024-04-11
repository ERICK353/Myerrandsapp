package com.example.myapplication.App

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.ModifierLocalReadScope
import com.example.myapplication.ErrandAppRouter
import com.example.myapplication.Screen
import com.example.myapplication.Screens.AddErrandScreen
import com.example.myapplication.Screens.DashBoardScreen
import com.example.myapplication.Screens.LoginScreen
import com.example.myapplication.Screens.SignUpScreen
import com.example.myapplication.Screens.TermsandConditions


@Composable
fun Errandsapp(){
Surface (modifier=Modifier
    .fillMaxSize(),
    color= Color.White,
    ){
    Crossfade(targetState = ErrandAppRouter.currentscreen, label = "") { currentState->
        when(currentState.value){
            is Screen.SignUpScreen -> {
                SignUpScreen()
            }
            is Screen.TermsandConditions -> {
                TermsandConditions()
            }
            is Screen.LoginScreen-> {
                LoginScreen()
            }
            is Screen.DashBoardScreen-> {
                DashBoardScreen()
            }
            is Screen.AddErrandScreen -> {
             AddErrandScreen()
            }
        }
        
    }

}
}