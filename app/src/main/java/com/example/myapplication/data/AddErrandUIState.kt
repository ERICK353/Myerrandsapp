package com.example.myapplication.data

data class AddErrandUIState(
    var errandtype:String="",
    var errandlocation:String="",
    var errandadress:String="",
    var shortdescription:String="",





    var errandtypeError:Boolean=false,
    var errandlocationError:Boolean=false,
    var errandadressError:Boolean=false,
    var shortadescriptionError:Boolean=false

)
