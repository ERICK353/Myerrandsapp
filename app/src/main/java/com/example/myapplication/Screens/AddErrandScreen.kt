package com.example.myapplication.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.constraintlayout.compose.HorizontalAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.Components.MyTextInput
import com.example.myapplication.LogInVeiwModel
import com.example.myapplication.R
import com.example.myapplication.data.AddErrandUIState
import com.example.myapplication.data.AddErrandViewModel
import com.example.myapplication.data.LogInUIEvent
import com.example.myapplication.data.rules.AddErrandUIEvent
import com.example.myapplication.datastore.StoreErrandType


@Preview
@Composable
fun  AddErrandScreen( addErrandViewModel:AddErrandViewModel= viewModel()) {

    //context
    val context= LocalContext.current

    //dataStore
val dataSore=StoreErrandType(context)
//geterrandtype
    val errandtype=dataSore.geterrandtype.collectAsState(initial = "")
    Surface(
        modifier = Modifier.
    fillMaxSize()) {
        Column(
horizontalAlignment =Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {


Column(
    modifier= Modifier
        .fillMaxSize()
        .clip(
            RoundedCornerShape(
                topStart = 25.dp,
                topEnd = 25.dp,
                bottomStart = 25.dp,
                bottomEnd = 25.dp
            )
        )
        .background(
            color = Color.White
        )

)
{

   Box(
       modifier= Modifier
           .fillMaxWidth()
           .height(100.dp)
           .align(Alignment.CenterHorizontally)
   ){
       if(errandtype.value.toString()=="electrical"){
           Image(painter = painterResource(id =R.drawable.idea), contentDescription ="")

   }
     else{
           Text(text = "Nothing")


     }

   }

    Text(text = "Enter Your Errand Details:",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        textDecoration = TextDecoration.Underline,
        modifier=Modifier
            .padding(20.dp)

    )

    Text(text = errandtype.value.toString(),
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        modifier=Modifier
    )
    DropDownLocation(
        onTextSelected = {
            addErrandViewModel.onEvent(AddErrandUIEvent.ErrandLocationChanged(it))
        },
        errorStatus =addErrandViewModel.addderrandUIState.value.errandlocationError
    )
    Text(text = "Errands Address",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        modifier=Modifier

    )
    AdressInput(
        onTextSelected = {
            addErrandViewModel.onEvent(AddErrandUIEvent.ErrandAddressChanged(it))
        },
        errorStatus =addErrandViewModel.addderrandUIState.value.errandadressError

    )
    Text(text = "Short Description",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        modifier=Modifier
    )
    ShortDescription(
        onTextSelected = {
            addErrandViewModel.onEvent(AddErrandUIEvent.ShortDescriptionChanged(it))
        },
        errorStatus =addErrandViewModel.addderrandUIState.value.shortadescriptionError


    )
    SendErrandButton()

}


        }


    }
}
@Composable
fun DropDownLocation(onTextSelected: (String) -> Unit,errorStatus:Boolean) {
    var expanded by remember { mutableStateOf(false)}
    var places = listOf("Nairobi Central", "Nairobi East", "Nairobi West ")
    var selectedlocations by remember { mutableStateOf("")}
    var textfieldsize by remember {
        mutableStateOf(Size.Zero)
    }
    val icon=if(expanded){
        Icons.Filled.KeyboardArrowUp
    }
        else{
            Icons.Filled.KeyboardArrowDown
        }

    Column(modifier = Modifier.padding(20.dp)) {
        OutlinedTextField(value =selectedlocations ,
            onValueChange ={selectedlocations=it
                           onTextSelected(it)},
            modifier= Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    textfieldsize = coordinates.size.toSize()
                },
            label = { Text(text = "Select Errand Location")},
            trailingIcon = {
                Icon(icon,"",Modifier.clickable { expanded=!expanded })
            }
            )
    }
    DropdownMenu(expanded = expanded,
        onDismissRequest = { expanded=false},
        modifier=Modifier.fillMaxWidth()
        ) {
        places.forEach { label->
            DropdownMenuItem(onClick = {
            selectedlocations=label
            expanded=false}) {
                Text(text = label)

        } }

    }
    }
@Composable
fun DropDownErrandtype() {
    var expanded by remember { mutableStateOf(false)}
    var places = listOf("Electrical", "Building", "Beauty&Cosmetics","Food","Clothing","Motor Vehicle")
    var selectederrand by remember { mutableStateOf("")}
    var textfieldsize by remember {
        mutableStateOf(Size.Zero)
    }
    val icon=if(expanded){
        Icons.Filled.KeyboardArrowUp
    }
    else{
        Icons.Filled.KeyboardArrowDown
    }

    Column(modifier = Modifier.padding(20.dp)) {
        OutlinedTextField(value =selectederrand ,
            onValueChange ={selectederrand=it
                           },
            modifier= Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    textfieldsize = coordinates.size.toSize()
                },
            label = { Text(text = "Select Errand Type")},
            trailingIcon = {
                Icon(icon,"",Modifier.clickable { expanded=!expanded })
            }
        )
    }
    DropdownMenu(expanded = expanded,
        onDismissRequest = { expanded=false},
        modifier=Modifier.fillMaxWidth()
    ) {
        places.forEach { label->
            DropdownMenuItem(onClick = {
                selectederrand=label
                expanded=false}) {
                Text(text = label)

            } }

    }
}
@Composable
fun AdressInput(onTextSelected: (String) -> Unit,errorStatus:Boolean) {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        modifier=Modifier.padding(20.dp),
        value = text,
        onValueChange = { text = it
            onTextSelected(it)

                        },
        label = { Text("Errands Address") },
        leadingIcon = {
            Icon(imageVector = Icons.Filled.LocationOn, contentDescription = null)
        }
    )
}
@Composable
fun ShortDescription(onTextSelected: (String) -> Unit,errorStatus:Boolean) {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        modifier=Modifier.padding(20.dp),
        value = text,
        onValueChange = { text = it
                        onTextSelected(it)},
        label = { Text("Short Description") },
        leadingIcon = {
            Icon(imageVector = Icons.Filled.FavoriteBorder, contentDescription = null)
        }
    )
}
@Composable
fun SendErrandButton() {
    OutlinedButton(modifier=Modifier.fillMaxWidth(),
        onClick = { }) {
        Text(text="Send Errand",
            color = Color.Green


            )
    }
}