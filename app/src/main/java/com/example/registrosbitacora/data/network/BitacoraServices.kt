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
    private var sendMessage:String="";
    //3 tipos de hilos
    // main el que pinta la ui
    //io que no requiere mucho procesamiento
    //default procesaro informacion
    suspend fun guardaEntradaEmpleado(clave:String, protocolo:String): String{
          return withContext(Dispatchers.IO){
            val response:Response<responseServices> = retrofit.create(ApiClient::class.java).saveEntradaEmpleado(DatosEmpleado(clave, protocolo))
            if(!response.isSuccessful){
                sendMessage="Error de conexión"
            }else{
                sendMessage=  response.body()!!.respMensaje.toString()
            }
              sendMessage
        }
    }
    suspend fun guardaSalidaEmpleado(clave:String): String{
        return withContext(Dispatchers.IO){
            val response:Response<responseServices> = retrofit.create(ApiClient::class.java).saveSalidaEmpleado(DatosEmpleado(clave,""))
            if(!response.isSuccessful){
                sendMessage="Error de conexión"
            }else{
                sendMessage=  response.body()!!.respMensaje.toString()
            }
            sendMessage
        }
    }

    suspend fun guardaEntradaVehiculo(datosVehiculo: DatosVehiculo): String{
        return withContext(Dispatchers.IO){
            val response:Response<responseServices> = retrofit.create(ApiClient::class.java).saveEntradaVehiculos(datosVehiculo)
            if(!response.isSuccessful){
                sendMessage="Error de conexión"
            }else{
                sendMessage=  response.body()!!.respMensaje.toString()
            }
            sendMessage
        }
    }
    suspend fun guardaSalidaVehiculo(placa:String):String{
        return withContext(Dispatchers.IO){
            val response:Response<responseServices> =retrofit.create(ApiClient::class.java).saveSalidaVehiculos(
                DatosVehiculoSalida (placa)
            )
            if(!response.isSuccessful){
                sendMessage="Error de conexión"
            }else{
                sendMessage=  response.body()!!.respMensaje.toString()
            }
            sendMessage
        }
    }
    suspend fun guardaEntradaVisitas(datosVisitas: DatosVisitas):String{
        return withContext(Dispatchers.IO){
            val response:Response<responseServices> =retrofit.create(ApiClient::class.java).saveEntradaVisita(
                (datosVisitas)
            )
            if(!response.isSuccessful){
                sendMessage="Error de conexión"
            }else{
                sendMessage=  response.body()!!.respMensaje.toString()
            }
            sendMessage
        }
    }
    suspend fun guardaSalidaVisitas(noTarjeta: Tarjeta):String{
        return withContext(Dispatchers.IO){
            val response:Response<responseServices> =retrofit.create(ApiClient::class.java).saveSalidaVisita(
                (noTarjeta)
            )
            if(!response.isSuccessful){
                sendMessage="Error de conexión"
            }else{
                sendMessage=  response.body()!!.respMensaje.toString()
            }
            sendMessage
        }
    }
}