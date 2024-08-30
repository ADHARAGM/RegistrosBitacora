package com.example.registrosbitacora.ui.view.salida

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.registrosbitacora.R
import com.example.registrosbitacora.databinding.ActivityVehiculosBinding
import com.example.registrosbitacora.databinding.ActivityVehiculosSalidaBinding
import com.example.registrosbitacora.ui.viewmodel.VehiculosSalidaActivityViewModel
import com.example.registrosbitacora.utils.DialogAlert
import com.example.registrosbitacora.utils.observeOnce

class VehiculosSalidaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVehiculosSalidaBinding
    private val vehiculosSalidaActivityViewModel: VehiculosSalidaActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityVehiculosSalidaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Listeners()
    }

    private fun Listeners() {
        binding.btnGuardarSalidaVehiculo.setOnClickListener {
            if(binding.placaEt.text.isNullOrEmpty())
            {
                DialogAlert(this,"Mensaje","Inserte placa")
            }else{
                vehiculosSalidaActivityViewModel.guardaSalidaVehiculo(binding.placaEt.text.toString())
                vehiculosSalidaActivityViewModel.getMessageData().observeOnce(Observer { resp ->
                    if (!resp.respMensaje.isEmpty()) {
                        DialogAlert(this, "Mensaje", resp.respMensaje)

                        //Toast.makeText(this, it.respMensaje, Toast.LENGTH_LONG).show()
                    } else {
                        DialogAlert(this, "Mensaje", "ERROR")
                    }
                })
            }
        }
    }
}