package com.example.registrosbitacora.domain

import com.example.registrosbitacora.data.model.DatosVisitas
import com.example.registrosbitacora.data.model.Tarjeta
import com.example.registrosbitacora.data.model.responseServices
import com.example.registrosbitacora.data.network.VisitasRepository

class SaveSalidaVisitasIUseCase {
    private val repository = VisitasRepository()

    suspend operator fun invoke(tarjeta: Tarjeta): responseServices?= repository.saveSalidaVisitas(tarjeta )
}