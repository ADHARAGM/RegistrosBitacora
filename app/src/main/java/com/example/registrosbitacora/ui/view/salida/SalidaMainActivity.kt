package com.example.registrosbitacora.ui.view.salida

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.registrosbitacora.databinding.ActivitySalidaMainBinding

class SalidaMainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivitySalidaMainBinding
    private lateinit var intent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySalidaMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listeners()
    }

    private fun listeners() {
        binding.personalSalidaBtn.setOnClickListener {
            intent= Intent(this, PersonalSalidaActivity::class.java)
            startActivity(intent)
        }
        binding.visitasSalidaBtn.setOnClickListener {
            intent= Intent(this, VisitasSalidaActivity::class.java)
            startActivity(intent)
        }
        binding.vehiculosSalidaBtn.setOnClickListener {
            intent=Intent(this, VehiculosSalidaActivity::class.java)
            startActivity(intent)
        }
    }
}