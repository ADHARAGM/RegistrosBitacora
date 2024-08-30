package com.example.registrosbitacora.data.network

import com.example.registrosbitacora.data.model.DatosEmpleado
import com.example.registrosbitacora.data.model.responseServices

class EmpleadosRepository {
    private val api = BitacoraServices()

    suspend fun saveEntradaEmpleados(clave:String, protocolo:String) : responseServices{

        val response=api.guardaEntradaEmpleado(clave,protocolo)

        return response
    }
    suspend fun saveSalidaEmpleados(clave:String) : responseServices{

        val response=api.guardaSalidaEmpleado(clave)

        return response
    }
}