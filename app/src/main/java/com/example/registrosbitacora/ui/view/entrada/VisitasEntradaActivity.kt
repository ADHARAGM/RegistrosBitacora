package com.example.registrosbitacora.ui.view.entrada

import android.location.GnssAntennaInfo.Listener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.registrosbitacora.R
import com.example.registrosbitacora.data.model.DatosVisitas
import com.example.registrosbitacora.databinding.ActivityVehiculosBinding
import com.example.registrosbitacora.databinding.ActivityVisitasEntradaBinding
import com.example.registrosbitacora.ui.viewmodel.VisitasEntradaActivityViewModel
import com.example.registrosbitacora.utils.DialogAlert
import com.example.registrosbitacora.utils.observeOnce

class VisitasEntradaActivity : AppCompatActivity() {
    private lateinit var binding:ActivityVisitasEntradaBinding
    // private val vehiculosEntradaActivityViewModel: VehiculosEntradaActivityViewModel by viewModels()
    private val visitiasEntradaActivityViewModel: VisitasEntradaActivityViewModel by viewModels()
    private var protocolo:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=ActivityVisitasEntradaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Listeners()
    }

    private fun Listeners() {
        binding.btnGuardarEntradaVisitas.setOnClickListener {
            if (  binding.nombreVisitaEt.text.toString().isNullOrEmpty() ||
                  binding.provieneEt.text.toString().isNullOrEmpty()||
                  binding.asutoVisitaEt.text.toString().isNullOrEmpty()||
                  binding.departamentoEt.text.toString().isNullOrEmpty()||
                  binding.nombreDirigeEt.text.toString().isNullOrEmpty()||
                  binding.noTarjetaEt.text.toString().isNullOrEmpty()||
                  protocolo.isNullOrEmpty()) {
                DialogAlert(this, "Mensaje","Inserte todos los datos que se te piden")
            } else {
                protocolo = if (binding.rbSi.isChecked) "si" else "no"
                visitiasEntradaActivityViewModel.guardaEntradaVehiculo(
                    DatosVisitas(
                        binding.nombreVisitaEt.text.toString(),
                        binding.provieneEt.text.toString(),
                        binding.asutoVisitaEt.text.toString(),
                        binding.departamentoEt.text.toString(),
                        binding.nombreDirigeEt.text.toString(),
                        binding.noTarjetaEt.text.toString(),
                        protocolo

                    )
                )
            }
            visitiasEntradaActivityViewModel.getMessageData().observeOnce { resp ->
                if (!resp.respMensaje.isEmpty()) {
                    DialogAlert(this, "Mensaje", resp.respMensaje)
                    //Toast.makeText(this, it.respMensaje, Toast.LENGTH_LONG).show()
                } else {
                    DialogAlert(this, "Mensaje", "ERROR")
                }
            }
        }
    }
}