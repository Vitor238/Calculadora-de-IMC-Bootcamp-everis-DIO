package com.vitor238.calculadoradeimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        calcularBTN.setOnClickListener {
            if(alturaEDT.text.isNotBlank()){
                if(pesoEDT.text.isNotBlank()){
                    calcularIMC(pesoEDT.text.toString(),alturaEDT.text.toString())
                }else{
                    Toast.makeText(this, R.string.digite_seu_peso, Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, R.string.digite_sua_altura, Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun calcularIMC(peso: String, altura: String) {
        val pesoFloat = peso.toFloatOrNull()
        val alturaFloat = altura.toFloatOrNull()

        if(pesoFloat != null && alturaFloat != null){
            val imc = pesoFloat / (alturaFloat * alturaFloat)
            val resultado = when{
                imc < 18.5 ->{
                    getString(R.string.magreza)
                }
                imc in 18.5..24.9 -> {
                    getString(R.string.saudavel)
                }
                imc in 25.0..29.9 -> {
                    getString(R.string.sobrepeso)
                }
                imc in 30.0..34.9 -> {
                    getString(R.string.obesidade_grau_i)
                }
                imc in 35.0..39.9 -> {
                    getString(R.string.obesidade_grau_ii)
                }
                else ->{
                    getString(R.string.obesidade_grau_iii)
                }
            }
            val intent = Intent(this,ResultActivity::class.java)
            intent.putExtra("imc",imc)
            intent.putExtra("resultado",resultado)
            startActivity(intent)
        }
    }
}