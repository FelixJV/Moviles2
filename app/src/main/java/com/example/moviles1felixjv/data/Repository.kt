package com.example.moviles1felixjv.data

import com.example.moviles1felixjv.domain.domain.modelo.Videojuego

class Repository {
    companion object{
        private val videojuegos = mutableListOf<Videojuego>()
        fun getInstance(): Repository = Repository();
    }

    init {
        videojuegos.add(Videojuego("Call of Duty","Modern Warfare"))
        videojuegos.add(Videojuego("HellDivers", "2"))
        videojuegos.add(Videojuego("Counter Strike", "Global Ofensive"))
    }
    fun addVideojuego(videojuego:Videojuego) = videojuegos.add(videojuego)
    fun getVideojuego(): List<Videojuego>{
        return videojuegos
    }

}