package com.example.myapplication.data

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.rules.AddErrandUIEvent
import com.example.myapplication.data.rules.Validator
import com.example.myapplication.datastore.StoreErrandType
import com.google.firebase.Firebase
import com.google.firebase.database.database
import kotlinx.coroutines.launch


class AddErrandViewModel(): ViewModel() {
    private val TAG=AddErrandViewModel::class.simpleName
    var addderrandUIState= mutableStateOf(AddErrandUIState())
    var allvalidationerranddatapassed= mutableStateOf(false)
    var sendingErrandinProgress= mutableStateOf(false)

    fun onEvent(event:AddErrandUIEvent){
        validateerranddata()
        when(event){
          is AddErrandUIEvent.ErrandTypeChanged->{
              addderrandUIState.value=addderrandUIState.value.copy(
                  errandtype = event.ErrandType

              )
              printState()
          }
            is AddErrandUIEvent.ErrandLocationChanged->{
                addderrandUIState.value=addderrandUIState.value.copy(
                    errandlocation = event.ErrandLocation

                )
                printState()
            }
            is AddErrandUIEvent.ErrandAddressChanged->{
                addderrandUIState.value=addderrandUIState.value.copy(
                    errandadress = event.ErrandAdrress

                )
                printState()
            }
            is AddErrandUIEvent.ShortDescriptionChanged->{
                addderrandUIState.value=addderrandUIState.value.copy(
                    shortdescription = event.ShortDescription

                )
                printState()

            }
            is AddErrandUIEvent.SendErrandButtonClicked->{
              senderranddata()


            }

        }


    }


    fun validateerranddata(){
        val ErrandTypeResult=Validator.validateErrandType(
            errandType =addderrandUIState.value.errandtype
        )
        val ErrandLocationResult=Validator.validateErrandLocation(
            errandLocation = addderrandUIState.value.errandlocation
        )
        val ErrandAdressResult=Validator.validateErrandAddress(
            errandAddress = addderrandUIState.value.errandadress
        )
        val ShortDescriptionResult=Validator.validateShortDescription(
            ShortDescription = addderrandUIState.value.shortdescription

        )
        Log.d(TAG,"Inside validatedatawithrules")
        Log.d(TAG,"ErrandtypeResult=$ErrandTypeResult")
        Log.d(TAG,"ErrandLocationResult=$ErrandLocationResult")
        Log.d(TAG,"ErrandAdress=$ErrandAdressResult")
        Log.d(TAG,"ShortDescription=$ShortDescriptionResult")


        addderrandUIState.value=addderrandUIState.value.copy(
            errandtypeError = ErrandTypeResult.status,
            errandlocationError =ErrandLocationResult.status,
            errandadressError = ErrandAdressResult.status,
            shortadescriptionError =ShortDescriptionResult.status,

        )
      if(ErrandTypeResult.status && ErrandLocationResult.status&&ErrandAdressResult.status&&ShortDescriptionResult.status){
          allvalidationerranddatapassed.value=true
      }
        else{
          allvalidationerranddatapassed.value=false
        }



    }
    private fun printState(){
        Log.d(TAG,"Inside printstate")
        Log.d(TAG,addderrandUIState.value.toString())
    }


    data class userdata(val errandtype:String,val errandlocation:String,val errandadress:String,val shortdescription:String)
    fun senderranddata() {
        val erranddata=userdata(
            errandtype=addderrandUIState.value.errandtype,
            errandlocation=addderrandUIState.value.errandlocation,
            errandadress = addderrandUIState.value.errandadress,
            shortdescription = addderrandUIState.value.shortdescription
        )

        val  db=Firebase.database

        val myref=db.getReference("userdata")
        myref.child("User1").setValue(erranddata)
            .addOnCompleteListener {
                Log.d("Firebase", "Data added successfully")
            }
            .addOnFailureListener { exception ->

                Log.e("Firebase", "Error adding data: ${exception.message}")
            }





    }

}