package com.example.moviles1felixjv.domain.domain.usecases.videojuegos

import com.example.moviles1felixjv.data.Repository
import com.example.moviles1felixjv.domain.domain.modelo.Videojuego


class AddVideojuego(private val repository: Repository) {
    operator fun invoke(videojuego: Videojuego): Boolean{
        return repository.addVideojuego(videojuego)
    }
}