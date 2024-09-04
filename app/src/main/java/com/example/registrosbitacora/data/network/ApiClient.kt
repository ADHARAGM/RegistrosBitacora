package com.example.registrosbitacora.data.network

import com.example.registrosbitacora.data.model.DatosEmpleado
import com.example.registrosbitacora.data.model.DatosVehiculo
import com.example.registrosbitacora.data.model.DatosVehiculoSalida
import com.example.registrosbitacora.data.model.DatosVisitas
import com.example.registrosbitacora.data.model.Tarjeta
import com.example.registrosbitacora.data.model.responseServices
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiClient {

    @POST("EntradaEmpleado/")
    suspend fun saveEntradaEmpleado(@Body datosEmpleados: DatosEmpleado): Response<responseServices>

    @POST("SalidaEmpleado/")
    suspend fun saveSalidaEmpleado(@Body datosEmpleados: DatosEmpleado): Response<responseServices>

    @POST("EntradaVehiculo/")
    suspend fun saveEntradaVehiculos(@Body datosVehiculo: DatosVehiculo): Response<responseServices>

    @POST("SalidaVehiculo/")
    suspend fun saveSalidaVehiculos(@Body datosVehiculoSalida: DatosVehiculoSalida): Response<responseServices>

    @POST("EntradaVisitas/")
    suspend fun saveEntradaVisita(@Body datosVisitas: DatosVisitas): Response<responseServices>

    @POST("SalidaVisita/")
    suspend fun saveSalidaVisita(@Body tarjeta:Tarjeta): Response<responseServices>
}