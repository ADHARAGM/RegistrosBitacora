package com.example.registrosbitacora.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.registrosbitacora.data.model.responseServices
import com.example.registrosbitacora.domain.SaveEntradaEmpleadosIUseCase
import com.example.registrosbitacora.domain.SaveSalidaEmpleadosIUseCase
import kotlinx.coroutines.launch

class PersonalSalidaActivityViewModel: ViewModel() {

    private val data= MutableLiveData<responseServices>()
    private val getData= SaveSalidaEmpleadosIUseCase()


    fun guardaSalidaPersonal(clave:String){
        viewModelScope.launch {
            val result= getData(clave)
            data.postValue(result!!)
        }
    }

    fun getMessageData(): MutableLiveData<responseServices> {
        return data
    }
}