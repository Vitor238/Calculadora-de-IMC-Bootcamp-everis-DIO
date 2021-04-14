package com.vitor238.calculadoradeimc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*
import java.text.DecimalFormat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        exibirResultado()
    }

    private fun exibirResultado() {
        val imc = intent.getFloatExtra("imc",0f)
        val resultado = intent.getStringExtra("resultado")

        resultadoTXT.text = resultado
        imcTXT.text = "%.2f".format(imc)
        faixaTXT.text = getString(R.string.faixa_x_imc, resultado)

        val faixa = when (resultado) {
            getString(R.string.magreza) -> {
                getString(R.string.faixa_magreza)
            }
            getString(R.string.saudavel) -> {
                getString(R.string.faixa_saudavel)
            }
            getString(R.string.sobrepeso) -> {
                getString(R.string.faixa_sobrepeso)
            }
            getString(R.string.obesidade_grau_i) -> {
                getString(R.string.faixa_obesidade_i)
            }
            getString(R.string.obesidade_grau_ii) -> {
                getString(R.string.faixa_obesidade_ii)
            }
            else ->{
                getString(R.string.faixa_obesidade_iii)
            }
        }

        valorFaixaTXT.text = faixa
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}