package com.example.myapplication.datastore

import android.content.Context

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.io.IOException


class StoreErrandType(private val context: Context) {
    companion object {
        private val Context.datastore: DataStore<Preferences> by preferencesDataStore("errandtype")
        val ERRAND_TYPE_KEY= stringPreferencesKey("errandtype")
    }

    val geterrandtype: Flow<String?> =context.datastore.data
        .map { preferences ->
            preferences[ERRAND_TYPE_KEY]?:""
        }

    suspend fun saveerrandtype(name:String){
        context.datastore.edit {preferences->
            preferences[ERRAND_TYPE_KEY]=name

        }

    }
    suspend fun deleteerrandtype(context: Context) {
        context.datastore.edit { preferences ->
            preferences.remove(ERRAND_TYPE_KEY)
        }

    }
}