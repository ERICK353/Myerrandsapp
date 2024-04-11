package com.example.myapplication.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.Components.AllErrands
import com.example.myapplication.Components.TaskComponent
import com.example.myapplication.Components.TopBar
import com.example.myapplication.datastore.StoreErrandType


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DashBoardScreen() {

    var selectedScreen by remember{ mutableStateOf(0) }
    val screens= listOf("Home","Calender","Notification","Messages")
    val names=listOf("Home","Calender","Notification","Messages")



    Scaffold(

        bottomBar = {
            BottomNavigation(
            modifier = Modifier
                .height(80.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 25.dp,
                        topEnd = 25.dp,
                        bottomStart = 0.dp,
                        bottomEnd = 0.dp
                    )
                ),
            backgroundColor =Color.Black,
            elevation = 0.dp,
        ) {
            screens.forEachIndexed { index, _ ->
                val icon: ImageVector = when (index){
                    0 -> Icons.Filled.Home
                    1 -> Icons.Filled.DateRange
                    2 -> Icons.Filled.MailOutline
                    3 ->Icons.Filled.AccountCircle

                    else -> Icons.Filled.Home

                }
                BottomNavigationItem(selected =selectedScreen==index ,
                    onClick = { selectedScreen=index },
                    icon = {
                        Box (
                            modifier= Modifier
                                .size(60.dp)
                                .clip(CircleShape)
                                .background(if (selectedScreen == index) Color.White else Color.Transparent),
                            contentAlignment = Alignment.Center
                        ){
                            Icon(imageVector = icon,
                                contentDescription ="Screen",
                                modifier = Modifier
                                    .size(50.dp)
                                    .padding(12.dp),
                                tint = if(selectedScreen==index) Color.Black else Color.White
                            )


                        }

                    }, label =  { when(index){
                        0 ->Text(
                            color=Color.White,
                            text ="Errands"
                        )
                        1 ->Text( color=Color.White,
                            text ="Calender" )
                        2 ->Text(
                            color=Color.White,
                            text ="Messages")
                        3 ->Text(
                            color=Color.White,
                            text="Profile")
                    }}
                )
            }
        }
        }
    ) { when(selectedScreen){
        0-> AllErrands()
        1-> TaskComponent()
        2-> Text(text ="Coming next" )
        3-> TopBar()
    }


    }
}




@Preview
@Composable
fun DefaultDashBoardScreen(){
    DashBoardScreen()
}