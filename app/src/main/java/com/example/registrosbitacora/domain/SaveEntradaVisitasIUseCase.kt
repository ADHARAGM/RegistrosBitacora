package com.example.registrosbitacora.domain

import com.example.registrosbitacora.data.model.DatosVehiculo
import com.example.registrosbitacora.data.model.DatosVisitas
import com.example.registrosbitacora.data.model.responseServices
import com.example.registrosbitacora.data.network.VehiculosRepository
import com.example.registrosbitacora.data.network.VisitasRepository

class SaveEntradaVisitasIUseCase {
    private val repository = VisitasRepository()

    suspend operator fun invoke(datosVisitas: DatosVisitas): responseServices?= repository.saveEntradaVisitas(datosVisitas )
}