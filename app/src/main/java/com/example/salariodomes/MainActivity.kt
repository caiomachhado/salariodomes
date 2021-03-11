package com.example.salariodomes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    var textViewNomeFuncionario : TextInputEditText? = null
    var textQuantidadeHoraTrabalhada : TextInputEditText? = null
    var textQuantidadeDiasTrabalhados : TextInputEditText? = null
    var textQuantidadeHorasDia : TextInputEditText? = null
    var text_view_salarioBruto : TextView? = null
    var text_view_descINSS : TextView? = null
    var text_view_descFGTS : TextView? = null
    var text_view_salarioLiquido : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        encontraViewPeloId()
        val buttonCalcular : Button = findViewById(R.id.btnCalcular)
        buttonCalcular.setOnClickListener {
            calcula()
        }
    }

    private fun calcula() {
        if (camposForamPreenchidos()) {
            var nomeFuncionario = textViewNomeFuncionario?.text.toString()
            var valHoraTrabalhada = textQuantidadeHoraTrabalhada?.text.toString().toFloat()
            var qtdDiasTrabalhados = textQuantidadeDiasTrabalhados?.text.toString().toInt()
            var qtdHoraDia = textQuantidadeHorasDia?.text.toString().toInt()
            calculaSalario(qtdHoraDia, qtdDiasTrabalhados, valHoraTrabalhada)
        } else {
            Toast.makeText(applicationContext, "Favor preencher os campos obrigatórios!", Toast.LENGTH_LONG).show()
        }
    }

    private fun camposForamPreenchidos(): Boolean {
        if(textQuantidadeDiasTrabalhados?.text.isNullOrEmpty()){
            textQuantidadeDiasTrabalhados?.error = "Campo em branco!"
            return false
        } else if(textQuantidadeHorasDia?.text.isNullOrEmpty()){
            textQuantidadeHorasDia?.error = "Campo em branco!"
            return false
        } else (textQuantidadeHoraTrabalhada?.text.isNullOrEmpty()){
            textQuantidadeHoraTrabalhada?.error = "Campo em branco"
        }


    }

    private fun calculaSalario(qtdHoraDia: Int, qtdDiasTrabalhados: Int, valHoraTrabalhada: Float) {
        // Variáveis de Desconto
        val inss = 0.05
        val fgts = 0.08

        val salarioBruto = qtdHoraDia * qtdDiasTrabalhados * valHoraTrabalhada
        val descINSS = salarioBruto * inss
        val descFTGS = salarioBruto * fgts
        val salarioLiquido = salarioBruto - (descFTGS + descINSS)
      mostraResultado(salarioLiquido, salarioBruto, descINSS, descFTGS)

    }


    private fun mostraResultado(salarioLiquido: Double, salarioBruto: Float, descINSS: Double, descFTGS: Double) {
        text_view_salarioLiquido?.let {
            it.text = "Salário Líquido R$${salarioLiquido}"
        }

        text_view_descFGTS?.let{
            it.text = "Desconto FGTS R$${descFTGS}"
        }

        text_view_salarioBruto?.let {
            it.text = "Salário Bruto: R$${salarioBruto}"
        }

        text_view_descINSS?.let{
            it.text = "Desconto INSS R$${descINSS}"
        }

    }

    private fun encontraViewPeloId(){
        textViewNomeFuncionario = findViewById(R.id.edit_text_nome_funcionario)
        textQuantidadeHoraTrabalhada = findViewById(R.id.edit_text_horas_trabalhadas)
        textQuantidadeDiasTrabalhados = findViewById(R.id.edit_text_dias_trabalhados)
        textQuantidadeHorasDia = findViewById(R.id.edit_text_valor_hora)
        text_view_salarioBruto= findViewById(R.id.text_view_salarioBruto)
        text_view_descINSS = findViewById(R.id.text_view_descINSS)
        text_view_descFGTS = findViewById(R.id.text_view_descFGTS)
        text_view_salarioLiquido = findViewById(R.id.text_view_SalarioLiquido)
    }
}

private operator fun Boolean.invoke(function: () -> Unit) {

}
