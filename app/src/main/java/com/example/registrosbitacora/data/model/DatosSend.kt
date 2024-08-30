package com.example.registrosbitacora.data.model

/*data class DatosEmpleado(
    val clave:String,
    val protocolo:String
)*/

data class DatosAgregarVehiculo(
    val nombreConductor:String,
    val numeroPersonas:Int,
    val placasVehiculo:String,
    val modeloVehiculo:String,
    val colorVehiculo: String
)

data class DatosAgregarVisitas(
    val nombreVisita:String,
    val proviene:String,
    val asunto:String,
    val departamento:String,
    val dirige:String,
    val tarjeta:Int,
    val protocolo: String
)

