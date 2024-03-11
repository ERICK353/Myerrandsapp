package com.example.myapplication.Screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun ErrandsAppNavigationGraph(){
    val navController= rememberNavController()
    NavHost(navController =navController , startDestination = Screen.LOGIN.route){
        composable(route = Screen.SIGNUP.route){

        }
        composable(route=Screen.DASHBOARD.route){
        }
        composable(route=Screen.TERMS.route){
        }
        composable(route = Screen.LOGIN.route){
        }
    }

}