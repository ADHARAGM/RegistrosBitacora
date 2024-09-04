package com.example.registrosbitacora.ui.view.entrada

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.registrosbitacora.R
import com.example.registrosbitacora.data.model.DatosVehiculo
import com.example.registrosbitacora.databinding.ActivityVehiculosBinding
import com.example.registrosbitacora.ui.viewmodel.VehiculosEntradaActivityViewModel
import com.example.registrosbitacora.utils.DialogAlert
import com.example.registrosbitacora.utils.observeOnce

class VehiculosEntradaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVehiculosBinding

    private val vehiculosEntradaActivityViewModel: VehiculosEntradaActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityVehiculosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Listeners()


    }

    private fun Listeners() {
        binding.btnGuardarEntradaVehiculos.setOnClickListener {
            if(binding.conductorEt.text.isNullOrEmpty() || binding.acompanianteEt.text.isNullOrEmpty()||binding.placaEt.text.isNullOrEmpty()|| binding.modeloEt.text.isNullOrEmpty()|| binding.colorEt.text.isNullOrEmpty())
            {
                DialogAlert(this,"Mensaje","Inserte todos los datos que se le piden")
            }else{
                vehiculosEntradaActivityViewModel.guardaEntradaVehiculo(
                    DatosVehiculo(binding.conductorEt.text.toString(),
                                binding.acompanianteEt.text.toString().toInt(),
                                binding.departamentoEtV.text.toString(),
                                binding.placaEt.text.toString(),
                                binding.modeloEt.text.toString(),
                                binding.colorEt.text.toString())
                )
                vehiculosEntradaActivityViewModel.getMessageData().observeOnce(Observer { resp ->
                    if (!resp.isEmpty()) {
                        DialogAlert(this, "Mensaje", resp)

                        //Toast.makeText(this, it.respMensaje, Toast.LENGTH_LONG).show()
                    } else {
                        DialogAlert(this, "Mensaje", "ERROR")
                    }
                })
            }
        }
    }
}