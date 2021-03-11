package com.example.salariodomes

import android.icu.util.Currency
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.textfield.TextInputEditText
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    var textViewNomeFuncionario : TextInputEditText? = null
    var textViewHoraTrabalhada : TextInputEditText? = null
    var textQtDiasTrabalhados : TextInputEditText? = null
    var textQtdHorasDia : TextInputEditText? = null
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
            var valHoraTrabalhada = textViewHoraTrabalhada?.text.toString().toFloat()
            var qtdDiasTrabalhados = textQtDiasTrabalhados?.text.toString().toInt()
            var qtdHoraDia = textQtdHorasDia?.text.toString().toInt()
            calculaSalario(qtdHoraDia, qtdDiasTrabalhados, valHoraTrabalhada)
        } else {
            Toast.makeText(applicationContext, "Preenche aí mano!", Toast.LENGTH_LONG).show()
        }
    }

    private fun camposForamPreenchidos(): Boolean {
        if(textQtDiasTrabalhados?.text.isNullOrEmpty()){
            textQtDiasTrabalhados?.error = "Campo em branco!"
            return false
        }
        return true
    }

    private fun calculaSalario(qtdHoraDia: Int, qtdDiasTrabalhados: Int, valHoraTrabalhada: Float) {
        // Variáveis de Desconto
        val inss = 0.05
        val fgts = 0.08

        val salarioBruto = qtdHoraDia * qtdDiasTrabalhados * valHoraTrabalhada
        val descINSS = salarioBruto * inss
        val descFTGS = salarioBruto * fgts
        val salarioLiquido = salarioBruto - (descFTGS + descINSS)
      //  mostraResultado(salarioLiquido, salarioBruto, descINSS, descFTGS)
        ResultadoBottomFragment().show(supportFragmentManager, "Resultado")
    }

    private fun mostraResultado(salarioLiquido: Double, salarioBruto: Float, descINSS: Double, descFTGS: Double) {
        text_view_salarioLiquido?.let {
            it.text = "Salário Líquido R$${salarioLiquido}"
        }
        text_view_descFGTS
        text_view_salarioBruto?.text = "Salário Bruto: R$${salarioBruto}"
        text_view_descINSS?.text = "Desconto INSS R$${descINSS}"
        text_view_descFGTS?.text = "Desconto FGTS R$${descFTGS}"
    }

    private fun encontraViewPeloId(){
        textViewNomeFuncionario = findViewById(R.id.text_view_nome_funcionario)
        textViewHoraTrabalhada = findViewById(R.id.text_view_horas_trabalhadas)
        textQtDiasTrabalhados = findViewById(R.id.edit_text_dias_trabalhados)
        textQtdHorasDia = findViewById(R.id.text_view_valor_hora)
        text_view_salarioBruto= findViewById(R.id.text_view_salarioBruto)
        text_view_descINSS = findViewById(R.id.text_view_descINSS)
        text_view_descFGTS = findViewById(R.id.text_view_descFGTS)
        text_view_salarioLiquido = findViewById(R.id.text_view_SalarioLiquido)
    }
}