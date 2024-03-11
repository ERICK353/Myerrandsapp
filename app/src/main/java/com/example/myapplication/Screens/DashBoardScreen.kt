package com.example.myapplication.Screens

import android.annotation.SuppressLint
import android.widget.Button
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
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigator
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.Components.ErrandsScreen
import com.example.myapplication.Components.TaskComponent
import com.example.myapplication.Components.TopBar


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DashBoardScreen() {
    var selectedScreen by remember{ mutableStateOf(1) }
    val screens= listOf("Calender","Home","Notification")
    val names=listOf("Calender","Home","Notification")

TopBar()
    Scaffold(
        bottomBar = {
            BottomNavigation(
            modifier = Modifier
                .height(80.dp)
                .padding(start = 5.dp, end = 5.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 25.dp,
                        topEnd = 25.dp,
                        bottomStart = 0.dp,
                        bottomEnd = 0.dp
                    )
                ),
            backgroundColor =Color(android.graphics.Color.parseColor("#38A505")),
            elevation = 0.dp,
        ) {
            screens.forEachIndexed { index, _ ->
                val icon: ImageVector = when (index){
                    0 -> Icons.Filled.DateRange
                    1 -> Icons.Filled.Home
                    2 -> Icons.Filled.MailOutline

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

                    }, label = { when(index){
                        0 ->Text(text ="Your Errands" )
                        1 ->Text(text ="Home" )
                        2 ->Text(text ="Messages")
                    }}
                )
            }
        }
        }
    ) { when(selectedScreen){
        0-> TaskComponent()
        1-> TopBar()
        2-> Text(text ="Coming next" )
    }


    }
}


@Preview
@Composable
fun DefaultDashBoardScreen(){
    DashBoardScreen()
}