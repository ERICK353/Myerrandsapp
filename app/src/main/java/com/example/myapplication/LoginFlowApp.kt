package com.example.myapplication

import android.app.Application
import com.google.firebase.FirebaseApp

class ErrandsApp:Application() {
   override fun onCreate(){
       super.onCreate()
       FirebaseApp.initializeApp(this)
   }
}