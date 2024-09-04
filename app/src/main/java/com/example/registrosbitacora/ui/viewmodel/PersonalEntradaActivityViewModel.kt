package com.example.registrosbitacora.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.registrosbitacora.data.model.responseServices
import com.example.registrosbitacora.domain.SaveEntradaEmpleadosIUseCase
import kotlinx.coroutines.launch

class PersonalEntradaActivityViewModel: ViewModel() {
    private val data= MutableLiveData<String>()
    private val getData=SaveEntradaEmpleadosIUseCase()


    fun guardaEntradaPersonal(clave:String, protocolo:String){
        viewModelScope.launch {
            val result= getData(clave, protocolo)

                data.postValue(result!!)


        }
    }

    fun getMessageData():MutableLiveData<String>{
        return data
    }
}