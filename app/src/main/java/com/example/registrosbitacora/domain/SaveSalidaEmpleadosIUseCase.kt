package com.example.registrosbitacora.domain

import com.example.registrosbitacora.data.model.responseServices
import com.example.registrosbitacora.data.network.EmpleadosRepository

class SaveSalidaEmpleadosIUseCase {
    private val repository = EmpleadosRepository()

    suspend operator fun invoke(clave:String): responseServices?= repository.saveSalidaEmpleados(clave)
}