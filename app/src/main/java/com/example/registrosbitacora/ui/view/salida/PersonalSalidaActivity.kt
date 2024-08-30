package com.example.registrosbitacora.ui.view.salida

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import com.example.registrosbitacora.R
import com.example.registrosbitacora.databinding.ActivityEntradaMainBinding
import com.example.registrosbitacora.databinding.ActivityPersonalSalidaBinding
import com.example.registrosbitacora.ui.viewmodel.PersonalSalidaActivityViewModel
import com.example.registrosbitacora.utils.DialogAlert
import com.example.registrosbitacora.utils.observeOnce

class PersonalSalidaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPersonalSalidaBinding
    private val personalSalidaActivityViewModel:PersonalSalidaActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonalSalidaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Listeners()
    }

    private fun Listeners() {
        binding.btnGuardaSalidaPersonal.setOnClickListener {
            if(!binding.claSalidaEd.text.isNullOrEmpty()){
                personalSalidaActivityViewModel.guardaSalidaPersonal(binding.claSalidaEd.text.toString())
                personalSalidaActivityViewModel.getMessageData().observeOnce(Observer { resp ->
                    if (!resp.respMensaje.isEmpty()) {
                        DialogAlert(this, "Mensaje", resp.respMensaje)

                        //Toast.makeText(this, it.respMensaje, Toast.LENGTH_LONG).show()
                    } else {
                        DialogAlert(this, "Mensaje", "ERROR")
                    }
                })
            }else{
                DialogAlert(this,"Mensaje","Ingrese una clave");
            }
        }
    }
}