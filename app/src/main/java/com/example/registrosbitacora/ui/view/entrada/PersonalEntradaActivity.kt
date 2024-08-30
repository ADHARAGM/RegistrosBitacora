package com.example.registrosbitacora.ui.view.entrada

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.registrosbitacora.R
import com.example.registrosbitacora.databinding.ActivityEntradaMainBinding
import com.example.registrosbitacora.databinding.ActivityPersonalEntradaBinding
import com.example.registrosbitacora.ui.viewmodel.PersonalEntradaActivityViewModel
import com.example.registrosbitacora.utils.DialogAlert
import com.example.registrosbitacora.utils.observeOnce

class PersonalEntradaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPersonalEntradaBinding
    private val personalEntradaActivityViewModel:PersonalEntradaActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonalEntradaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listeners()
    }

    private fun listeners() {
        binding.btnGuardaEntradaPersonal.setOnClickListener {
            if(!binding.claveEntradaEd.text.toString().isNullOrEmpty()) {
                var cnd = if (binding.rbSi.isChecked) "si" else "no"
                personalEntradaActivityViewModel.guardaEntradaPersonal(
                    binding.claveEntradaEd.text.toString(),
                    cnd
                )

                personalEntradaActivityViewModel.getMessageData().observeOnce(Observer { resp ->
                    if (!resp.respMensaje.isEmpty()) {
                        DialogAlert(this, "Mensaje", resp.respMensaje)

                        //Toast.makeText(this, it.respMensaje, Toast.LENGTH_LONG).show()
                    } else {
                        DialogAlert(this, "Mensaje", "ERROR")
                    }
                })
            }else{
                DialogAlert(this, "Mensaje", "Ingrese una clave")
            }

        }
    }


}