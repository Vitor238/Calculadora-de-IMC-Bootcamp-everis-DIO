package com.vitor238.calculadoradeimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.w("lifecycle", "CREATE - estou criando a tela")
        finish()
    }

    override fun onStart() {
        super.onStart()
        Log.w("lifecycle", "START - deixei a tela visível pra você")
    }

    override fun onResume() {
        super.onResume()
        Log.w("lifecycle", "RESUME - agora você pode interagir com a tela")
    }

    override fun onPause() {
        super.onPause()
        Log.w("lifecycle", "PAUSE - a tela perdeu o foco, você não pode mais interagir")
    }

    override fun onStop() {
        super.onStop()
        Log.w("lifecycle", "STOP - a tela não está visiviel mas ainda existe")
    }

    override fun onRestart() {
        super.onRestart()
        Log.w("lifecycle", "RESTART - a tela está retomando o foco")
    }

    override fun onDestroy() {
        Log.w("lifecycle", "DESTROY - oh não! a tela foi destruida")
        super.onDestroy()
    }
}