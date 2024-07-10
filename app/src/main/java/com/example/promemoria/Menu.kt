package com.example.promemoria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class Menu : AppCompatActivity() {

    //Creacion de variables
    lateinit var iv_iniciar: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        inicializar()
    }

    private fun inicializar() {
        iv_iniciar =findViewById(R.id.iv_iniciar)
    }

    fun inicioJuego(boton: View){
        //iv_iniciar.setOnClickListener{
        val intent = Intent(this, Juego::class.java)
        startActivity(intent)
        finish()
        // }
    }
}