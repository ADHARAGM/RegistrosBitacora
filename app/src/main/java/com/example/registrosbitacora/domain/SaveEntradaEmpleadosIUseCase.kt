package com.example.registrosbitacora.domain

import com.example.registrosbitacora.data.model.responseServices
import com.example.registrosbitacora.data.network.EmpleadosRepository

class SaveEntradaEmpleadosIUseCase { //interactor

    private val repository = EmpleadosRepository()

    suspend operator fun invoke(clave:String, protocolo:String): responseServices?= repository.saveEntradaEmpleados(clave, protocolo)

}