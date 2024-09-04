package com.example.registrosbitacora.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.registrosbitacora.data.model.DatosVisitas
import com.example.registrosbitacora.data.model.Tarjeta
import com.example.registrosbitacora.data.model.responseServices
import com.example.registrosbitacora.domain.SaveEntradaVisitasIUseCase
import com.example.registrosbitacora.domain.SaveSalidaVisitasIUseCase
import kotlinx.coroutines.launch

class VisitasSalidaActivityViewModel: ViewModel() {

    private val data= MutableLiveData<String>()
    private val getData= SaveSalidaVisitasIUseCase()


    fun guardaSalidaVehiculo(tarjeta: Tarjeta){
        viewModelScope.launch {
            val result= getData(tarjeta )
            data.postValue(result!!)
        }
    }

    fun getMessageData(): MutableLiveData<String> {
        return data
    }
}