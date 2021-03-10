package com.example.salariodomes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewNomeFuncionario : TextInputEditText = findViewById(R.id.txtNomeFuncionario)
        val textViewHoraTrabalhada : TextInputEditText = findViewById(R.id.txtValorHoraTrabalhada)
        val textQtDiasTrabalhados : TextInputEditText = findViewById(R.id.txtQtDiasTrabalhados)
        val textQtdHorasDia : TextInputEditText = findViewById(R.id.txtQtdHorasDia)


        var nomeFuncionario = textViewNomeFuncionario.text.toString()
        var valHoraTrabalhada = textViewHoraTrabalhada.text.toString().toFloat()
        var qtdDiasTrabalhados = textQtDiasTrabalhados.text.toString().toInt()
        var qtdHoraDia = textQtdHorasDia.text.toString().toInt()

            fun calculaSalario(){
                
            }

    }
}