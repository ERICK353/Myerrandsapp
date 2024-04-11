package com.example.myapplication.data.rules

import com.example.myapplication.data.LogInUIEvent

sealed class AddErrandUIEvent {
    data class ErrandTypeChanged(val ErrandType:String): AddErrandUIEvent()
    data class ErrandLocationChanged(val ErrandLocation:String): AddErrandUIEvent()
    data class ErrandAddressChanged(val ErrandAdrress:String):AddErrandUIEvent()
    data class ShortDescriptionChanged(val ShortDescription:String):AddErrandUIEvent()

    object SendErrandButtonClicked: AddErrandUIEvent()




}