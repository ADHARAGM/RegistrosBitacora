package com.example.registrosbitacora.data.model

import com.google.gson.annotations.SerializedName

//formato conel que se recibe desde el servidor
data class responseServices(@SerializedName("msg") val respMensaje: String)
