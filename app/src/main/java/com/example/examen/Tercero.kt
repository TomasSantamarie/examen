package com.example.examen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.examen.databinding.ActivityTerceroBinding

class Tercero : AppCompatActivity() {
    private lateinit var binding: ActivityTerceroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTerceroBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        var bundle = intent.extras
        var libross = bundle?.get("libros")
        binding.libros.setText(libross.toString())


        binding.nuevo.setOnClickListener{
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.atras.setOnClickListener{

            libros.deleteLibro(contador-1)
            var intent = Intent(this, Segundo::class.java)
            startActivity(intent)
        }
    }
}