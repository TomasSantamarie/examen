package com.example.examen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.examen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        binding.seguir.isEnabled = false
        binding.paginas.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                binding.seguir.isEnabled = binding.paginas.text.toString().toInt() >= 0



            }
        })

        binding.seguir.setOnClickListener{
            var titulo = binding.titulo.text.toString()
            var paginas = binding.paginas.text.toString().toInt()

            var intent = Intent(this, Segundo::class.java).apply {
                putExtra("titulo",titulo)
                putExtra("paginas",paginas)
            }
            startActivity(intent)
        }
    }
}