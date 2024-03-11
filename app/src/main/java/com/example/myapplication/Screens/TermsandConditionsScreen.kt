package com.example.myapplication.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.Components.HeadingtextComponents
import com.example.myapplication.Components.NormaltextComponents
import com.example.myapplication.R

@Composable
fun TermsandConditions(){
    Surface (modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(16.dp)
    ){
        Column {
            HeadingtextComponents(value = stringResource(id = R.string.termsandconditions) )
            NormaltextComponents(value = stringResource(id = R.string.hello))
        }


    }

}

@Preview
@Composable
fun Termsandconditionspreview(){
    TermsandConditions()
}