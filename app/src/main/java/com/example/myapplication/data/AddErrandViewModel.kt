package com.example.myapplication.data

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.rules.AddErrandUIEvent
import com.example.myapplication.data.rules.Validator

 class AddErrandViewModel: ViewModel(){
    var addderrandUIState= mutableStateOf(AddErrandUIState())
    var allvalidationerranddatapassed= mutableStateOf(false)
    var sendingErrandinProgress= mutableStateOf(false)
    fun onEvent(event:AddErrandUIEvent){

        when(event){
          is AddErrandUIEvent.ErrandTypeChanged->{
              addderrandUIState.value=addderrandUIState.value.copy(
                  errandtype = event.ErrandType

              )
          }
            is AddErrandUIEvent.ErrandLocationChanged->{
                addderrandUIState.value=addderrandUIState.value.copy(
                    errandlocation = event.ErrandLocation

                )
            }
            is AddErrandUIEvent.ErrandAddressChanged->{
                addderrandUIState.value=addderrandUIState.value.copy(
                    errandtype = event.ErrandAdrress

                )
            }
            is AddErrandUIEvent.ShortDescriptionChanged->{
                addderrandUIState.value=addderrandUIState.value.copy(
                    errandtype = event.ShortDescription

                )

            }
            is AddErrandUIEvent.SendErrandButtonClicked->{
               SendErrand()


            }

        }
        validateerranddata()

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
        addderrandUIState.value=addderrandUIState.value.copy(
            errandtypeError = ErrandTypeResult.status,
            errandlocationError =ErrandLocationResult.status,
            errandadressError = ErrandAdressResult.status,
            shortadescriptionError =ShortDescriptionResult.status

        )
        allvalidationerranddatapassed.value=ErrandTypeResult.status && ErrandLocationResult.status&&ErrandAdressResult.status&&ShortDescriptionResult.status



    }

    fun SendErrand(){




    }

}