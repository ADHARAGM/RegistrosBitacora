package com.example.registrosbitacora.ui.view

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatDelegate
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.Observer
import com.example.registrosbitacora.data.model.ThemeRegistroBitacoraModel
import com.example.registrosbitacora.databinding.ActivityMainBinding
import com.example.registrosbitacora.databinding.DialogThemeBinding
import com.example.registrosbitacora.ui.view.entrada.EntradaMainActivity
import com.example.registrosbitacora.ui.view.salida.SalidaMainActivity
import com.example.registrosbitacora.ui.viewmodel.MainActivityViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name="themeRegistroBitacora")
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainActivityViewModel: MainActivityViewModel by viewModels()
    private lateinit var dialogBinding: DialogThemeBinding
    private lateinit var dialog:Dialog;
    private lateinit var intent: Intent
    companion object{
        const val THEME ="key_theme"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        dialogBinding=DialogThemeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainActivityViewModel.onCreate(dataStore)
        mainActivityViewModel.typeTheme.observeForever( Observer { typeMode->
            dialogBinding.rbOscuro.isChecked=typeMode
            if(typeMode){
                modoOscuro()
            }else{
                modoClaro()
            }
        })
        listeners()
    }
    private fun listeners() {
        goToEntradaMainActivity()
        goToSalidaMainActivity()
        showDialogTheme()
    }
    private fun goToEntradaMainActivity(){
        binding.entradaBtn.setOnClickListener {
            intent= Intent(this, EntradaMainActivity::class.java)
            startActivity(intent)
        }
    }
    private fun goToSalidaMainActivity(){
        binding.salidaBtn.setOnClickListener {
            intent=Intent(this, SalidaMainActivity::class.java)
            startActivity(intent)
        }
    }
    private fun  showDialogTheme(){
        binding.fabAddTask.setOnClickListener {
            createDialogTheme()
        }
    }
    private fun createDialogTheme() {
        dialog = Dialog(this)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(dialogBinding.root)
        dialog.show()
        listenersDialog()
    }
    private fun listenersDialog() {
        dialogBinding.rbOscuro.setOnCheckedChangeListener { _, isChecked ->
            CoroutineScope(Dispatchers.IO).launch {
                mainActivityViewModel.saveOptions (dataStore,THEME, isChecked)
            }
            dialog.dismiss()
        }
    }
    private fun modoOscuro(){
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        delegate.applyDayNight()
    }
    private fun modoClaro(){
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        delegate.applyDayNight()
    }

}