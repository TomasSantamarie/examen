package com.example.examen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.examen.databinding.ActivitySegundoBinding

class Segundo : AppCompatActivity() {
    private lateinit var binding: ActivitySegundoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySegundoBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        var bundle = intent.extras
        var titulo = bundle?.getString("titulo")
        var paginas = bundle?.getInt("paginas")

        binding.seguir.isEnabled = false
        binding.ano.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                binding.seguir.isEnabled = binding.ano.text.toString().toInt() >= 0
            }
        })

        binding.seguir.setOnClickListener{

            var autor = binding.autor.text.toString()
            var ano = binding.ano.text.toString().toInt()

            if (titulo!=null && paginas!=null)
                libros.addLibro(Libro(titulo,paginas,autor,ano))

            var intent = Intent(this, Tercero::class.java).apply {
                putExtra("libros", libros)

            }
            contador++
            startActivity(intent)
        }

        binding.atras.setOnClickListener{
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}