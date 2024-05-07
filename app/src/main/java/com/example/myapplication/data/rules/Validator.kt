package com.example.myapplication.data.rules



object Validator {
    fun validateFirstName(fName:String):ValidationResult{
        return ValidationResult(
         (!fName.isNullOrEmpty()&&fName.length>=4)
)
    }
    fun validateLastName(lName:String):ValidationResult{
        return ValidationResult(
            (!lName.isNullOrEmpty()&&lName.length>=4)
        )
    }
    fun validateEmail(email:String):ValidationResult{
        return ValidationResult(
            (!email.isNullOrEmpty())
        )
    }
    fun validatePassword(password:String):ValidationResult{
        return ValidationResult(
            (!password.isNullOrEmpty()&&password.length>=6)
        )
    }
    fun validateTerms(statusValue: Boolean):ValidationResult{
        return ValidationResult(
            statusValue
        )
    }
    fun validateErrandType(errandType:String):ValidationResult{
        return ValidationResult(
            (!errandType.isNullOrEmpty()&&errandType.length>=4)
        )
    }
    fun validateErrandLocation(errandLocation:String):ValidationResult{
        return ValidationResult(
            (!errandLocation.isNullOrEmpty()&&errandLocation.length>=4)
        )
    }
    fun validateErrandAddress(errandAddress:String):ValidationResult{
        return ValidationResult(
            (!errandAddress.isNullOrEmpty()&&errandAddress.length>=4)
        )
    }
    fun validateShortDescription(ShortDescription:String):ValidationResult{
        return ValidationResult(
            (!ShortDescription.isNullOrEmpty()&&ShortDescription.length>=4)
        )
    }


}
data class ValidationResult(
    val status:Boolean=false
)