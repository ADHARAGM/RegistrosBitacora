package com.example.registrosbitacora.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.registrosbitacora.data.model.DatosVehiculo
import com.example.registrosbitacora.data.model.responseServices
import com.example.registrosbitacora.domain.SaveEntradaVehiculosIUseCase
import kotlinx.coroutines.launch

class VehiculosEntradaActivityViewModel :ViewModel ()
{
    private val data= MutableLiveData<String>()
    private val getData= SaveEntradaVehiculosIUseCase()


    fun guardaEntradaVehiculo(datosVehiculo:DatosVehiculo){
        viewModelScope.launch {
            val result= getData(datosVehiculo )
            data.postValue(result!!)
        }
    }

    fun getMessageData(): MutableLiveData<String> {
        return data
    }

}