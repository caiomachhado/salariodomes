package com.example.salariodomes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonCalcular : Button = findViewById(R.id.btnCalcular)
        buttonCalcular.setOnClickListener {

        // Variáveis de Catch
        val textViewNomeFuncionario : TextInputEditText = findViewById(R.id.txtNomeFuncionario)
        val textViewHoraTrabalhada : TextInputEditText = findViewById(R.id.txtValorHoraTrabalhada)
        val textQtDiasTrabalhados : TextInputEditText = findViewById(R.id.txtQtDiasTrabalhados)
        val textQtdHorasDia : TextInputEditText = findViewById(R.id.txtQtdHorasDia)
        val text_view_salarioBruto : TextView = findViewById(R.id.text_view_salarioBruto)
        val text_view_descINSS : TextView = findViewById(R.id.text_view_descINSS)
        val text_view_descFGTS : TextView = findViewById(R.id.text_view_descFGTS)
        val text_view_salarioLiquido : TextView = findViewById(R.id.text_view_SalarioLiquido)

        // Variáveis de Conversão
        var nomeFuncionario = textViewNomeFuncionario.text.toString()
        var valHoraTrabalhada = textViewHoraTrabalhada.text.toString().toFloat()
        var qtdDiasTrabalhados = textQtDiasTrabalhados.text.toString().toInt()
        var qtdHoraDia = textQtdHorasDia.text.toString().toInt()

        // Variáveis de Desconto
        var inss = 0.05
        var fgts = 0.08

        var salarioBruto = qtdHoraDia * qtdDiasTrabalhados * valHoraTrabalhada
        var descINSS = salarioBruto * inss
        var descFTGS = salarioBruto * fgts
        var salarioLiquido = salarioBruto - (descFTGS + descFTGS)

        text_view_salarioBruto.text = "Salário Bruto: R$${salarioBruto}"
        text_view_descINSS.text = "Desconto INSS R$${descINSS}"
        text_view_descFGTS.text = "Desconto FGTS R$${descFTGS}"
        text_view_salarioLiquido.text = "Salário Líquido R$${salarioLiquido}"



            }

    }
}