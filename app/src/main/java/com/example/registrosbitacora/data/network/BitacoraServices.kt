package com.example.registrosbitacora.data.network

import com.example.registrosbitacora.core.RetrofitHelper
import com.example.registrosbitacora.data.model.DatosEmpleado
import com.example.registrosbitacora.data.model.DatosVehiculo
import com.example.registrosbitacora.data.model.DatosVehiculoSalida
import com.example.registrosbitacora.data.model.DatosVisitas
import com.example.registrosbitacora.data.model.Tarjeta
import com.example.registrosbitacora.data.model.responseServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.create

class BitacoraServices {//esta es la que hara el llamado al servicio por internet

    private val retrofit= RetrofitHelper.getUrl()

    suspend fun guardaEntradaEmpleado(clave:String, protocolo:String): responseServices{
        return withContext(Dispatchers.IO){
            val response:responseServices = retrofit.create(ApiClient::class.java).saveEntradaEmpleado(DatosEmpleado(clave, protocolo))

            response
        }
    }

    suspend fun guardaSalidaEmpleado(clave:String): responseServices{
        return withContext(Dispatchers.IO){
            val response:responseServices = retrofit.create(ApiClient::class.java).saveSalidaEmpleado(DatosEmpleado(clave,""))

            response
        }
    }

    suspend fun guardaEntradaVehiculo(datosVehiculo: DatosVehiculo): responseServices{
        return withContext(Dispatchers.IO){
            val response:responseServices = retrofit.create(ApiClient::class.java).saveEntradaVehiculos(datosVehiculo)
            response
        }
    }
    suspend fun guardaSalidaVehiculo(placa:String):responseServices{
        return withContext(Dispatchers.IO){
            val response:responseServices=retrofit.create(ApiClient::class.java).saveSalidaVehiculos(
                DatosVehiculoSalida (placa)
            )
            response
        }
    }
    suspend fun guardaEntradaVisitas(datosVisitas: DatosVisitas):responseServices{
        return withContext(Dispatchers.IO){
            val response:responseServices=retrofit.create(ApiClient::class.java).saveEntradaVisita(
                (datosVisitas)
            )
            response
        }
    }
    suspend fun guardaSalidaVisitas(noTarjeta: Tarjeta):responseServices{
        return withContext(Dispatchers.IO){
            val response:responseServices=retrofit.create(ApiClient::class.java).saveSalidaVisita(
                (noTarjeta)
            )
            response?:responseServices("")
        }
    }
}