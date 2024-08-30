package com.example.registrosbitacora.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.registrosbitacora.data.model.DatosVehiculo
import com.example.registrosbitacora.data.model.DatosVisitas
import com.example.registrosbitacora.data.model.responseServices
import com.example.registrosbitacora.domain.SaveEntradaVehiculosIUseCase
import com.example.registrosbitacora.domain.SaveEntradaVisitasIUseCase
import kotlinx.coroutines.launch

class VisitasEntradaActivityViewModel: ViewModel() {
    private val data= MutableLiveData<responseServices>()
    private val getData= SaveEntradaVisitasIUseCase()


    fun guardaEntradaVehiculo(datosVisitas: DatosVisitas){
        viewModelScope.launch {
            val result= getData(datosVisitas )
            data.postValue(result!!)
        }
    }

    fun getMessageData(): MutableLiveData<responseServices> {
        return data
    }
}