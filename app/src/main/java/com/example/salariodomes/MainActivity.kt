package com.example.salariodomes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var nomeFuncionario = txtNomeFuncionario.text.toString()
        var valHoraTrabalhada = txtValorHoraTrabalhada.text.toString().toFloat()
        var qtdDiasTrabalhados = txtQtDiasTrabalhados.text.toString().toInt()
        var qtdHoraDia = txtQtdHorasDia.text.toString().toInt()

            fun calculaSalario(){
                
            }

    }
}