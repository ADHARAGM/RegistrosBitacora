package com.example.registrosbitacora.domain

import com.example.registrosbitacora.data.model.DatosVehiculo
import com.example.registrosbitacora.data.model.responseServices
import com.example.registrosbitacora.data.network.EmpleadosRepository
import com.example.registrosbitacora.data.network.VehiculosRepository

class SaveEntradaVehiculosIUseCase {

    private val repository = VehiculosRepository()

    suspend operator fun invoke(datosVehiculo: DatosVehiculo): String?= repository.saveEntradaVehiculos(datosVehiculo )
}