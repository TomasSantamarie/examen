package com.example.examen

import java.io.Serializable

class Libro(private var titulo : String, private var paginas : Int, private var autor : String,private var ano : Int ): Serializable{

    fun getTitulo():String{
        return titulo
    }
    fun setTitulo(titulo: String){
        this.titulo = titulo
    }

    fun getPaginas():Int{
        return paginas
    }
    fun setTitulo(paginas: Int){
        this.paginas = paginas
    }

    fun getAutor():String{
        return autor
    }
    fun setAutor(titulo: String){
        this.autor = autor
    }
    fun getAno():Int{
        return ano
    }
    fun setAno(ano: Int){
        this.ano = ano
    }

    override fun toString(): String {
        return "($titulo, $paginas, $autor, $ano)"
    }
}

class Lista():Serializable{
    private var lista = ArrayList<Libro>()
    fun addLibro(libro: Libro){
        lista.add(libro)
    }
    fun deleteLibro(int: Int){
        lista.removeAt(int)
    }

    override fun toString(): String {
        var aux=""
        for ((indice,item) in lista.withIndex()){
            aux+="Libro ${indice+1} [$item]    "
        }
        return aux
    }
}

var libros= Lista()
var contador = 0