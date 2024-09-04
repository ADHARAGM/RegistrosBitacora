package com.example.registrosbitacora.domain

import com.example.registrosbitacora.data.model.DatosVehiculo
import com.example.registrosbitacora.data.model.responseServices
import com.example.registrosbitacora.data.network.VehiculosRepository

class SaveSalidaVehiculosIUseCase {
    private val repository = VehiculosRepository()

    suspend operator fun invoke(placa:String): String?= repository.saveSalidaVehiculos(placa )
}