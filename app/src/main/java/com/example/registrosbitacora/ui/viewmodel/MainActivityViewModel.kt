package com.example.registrosbitacora.ui.viewmodel

import androidx.appcompat.app.AppCompatDelegate
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.registrosbitacora.data.model.ThemeRegistroBitacoraModel
import com.example.registrosbitacora.ui.view.MainActivity
import com.example.registrosbitacora.ui.view.dataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch


class MainActivityViewModel : ViewModel() {
    private var firstTime:Boolean = true
    val typeTheme= MutableLiveData<Boolean>()

    fun onCreate(dataStore: DataStore<Preferences>) {
        CoroutineScope(Dispatchers.IO).launch{ //mientras este valor es true entra ( corta el flow)
            getDataBase(dataStore).filter { firstTime }.collect{settingsModel->
                if(settingsModel!=null){
                    if(settingsModel.theme){
                        typeTheme.postValue(true)
                    }else{
                        typeTheme.postValue(false)
                    }
                    firstTime=false
                }
            }
        }
    }
    private fun getDataBase(dataStore: DataStore<Preferences>): Flow<ThemeRegistroBitacoraModel> {
        return dataStore.data.map {preferences->
            ThemeRegistroBitacoraModel(theme = preferences[booleanPreferencesKey(MainActivity.THEME)] ?: true)
        }
    }
    suspend fun saveOptions(dataStore: DataStore<Preferences>, themeKey: String, checked: Boolean) {
        dataStore.edit {preference->
            preference[booleanPreferencesKey(themeKey)]=checked
            firstTime=true
        }
    }

}