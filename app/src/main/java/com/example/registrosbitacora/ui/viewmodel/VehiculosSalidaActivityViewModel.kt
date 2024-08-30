package com.example.registrosbitacora.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.registrosbitacora.data.model.DatosVehiculo
import com.example.registrosbitacora.data.model.responseServices
import com.example.registrosbitacora.domain.SaveEntradaVehiculosIUseCase
import com.example.registrosbitacora.domain.SaveSalidaVehiculosIUseCase
import kotlinx.coroutines.launch

class VehiculosSalidaActivityViewModel: ViewModel() {
    private val data= MutableLiveData<responseServices>()
    private val getData= SaveSalidaVehiculosIUseCase()


    fun guardaSalidaVehiculo(placa:String){
        viewModelScope.launch {
            val result= getData(placa )
            data.postValue(result!!)
        }
    }

    fun getMessageData(): MutableLiveData<responseServices> {
        return data
    }
}