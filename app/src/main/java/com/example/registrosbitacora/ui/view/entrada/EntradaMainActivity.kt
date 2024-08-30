package com.example.registrosbitacora.ui.view.entrada

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.registrosbitacora.databinding.ActivityEntradaMainBinding

class EntradaMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEntradaMainBinding
    private lateinit var intent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEntradaMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listeners()
    }

    private fun listeners() {
        binding.personalEntradaBtn.setOnClickListener {
            intent= Intent(this, PersonalEntradaActivity::class.java)
            startActivity(intent)
        }
        binding.visitaEntradaBtn.setOnClickListener {
            intent= Intent(this, VisitasEntradaActivity::class.java)
            startActivity(intent)
        }
        binding.vehiculoEntranaBtn.setOnClickListener {
            intent=Intent (this, VehiculosEntradaActivity::class.java)
            startActivity(intent)
        }
    }
}