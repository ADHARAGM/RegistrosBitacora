package com.example.registrosbitacora.ui.view.salida

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.registrosbitacora.R
import com.example.registrosbitacora.data.model.Tarjeta
import com.example.registrosbitacora.databinding.ActivityVisitasSalidaBinding
import com.example.registrosbitacora.ui.viewmodel.VisitasSalidaActivityViewModel
import com.example.registrosbitacora.utils.DialogAlert
import com.example.registrosbitacora.utils.observeOnce

class VisitasSalidaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVisitasSalidaBinding
    private val visitasSalidaActivityViewModel: VisitasSalidaActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityVisitasSalidaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Listeners()

    }

    private fun Listeners() {
        binding.btnGuardarSalidaVisitas.setOnClickListener {
            if(binding.noTarjetaEt.text.toString().isNullOrEmpty()){
                DialogAlert(this, "Mensaje", "Inserte el número de tarjeta")
            }else {
                visitasSalidaActivityViewModel.guardaSalidaVehiculo(Tarjeta(binding.noTarjetaEt.text.toString()))
                visitasSalidaActivityViewModel.getMessageData().observeOnce(Observer { resp ->
                    if (!resp.isEmpty()) {
                        DialogAlert(this, "Mensaje", resp)
                    } else {
                        DialogAlert(this, "Mensaje", "ERROR")
                    }
                })
            }
        }

    }
}