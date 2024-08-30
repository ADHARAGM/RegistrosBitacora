package com.example.registrosbitacora.data.network

import com.example.registrosbitacora.data.model.DatosVehiculo
import com.example.registrosbitacora.data.model.responseServices

class VehiculosRepository {

    private val api = BitacoraServices()

    suspend fun saveEntradaVehiculos(datosVehiculo: DatosVehiculo) : responseServices {

        val response=api.guardaEntradaVehiculo(datosVehiculo)

        return response
    }
    suspend fun saveSalidaVehiculos(placa:String):responseServices{
        val response=api.guardaSalidaVehiculo(placa)
        return response
    }
}