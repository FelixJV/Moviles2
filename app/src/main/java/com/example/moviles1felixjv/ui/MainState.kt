package com.example.moviles1felixjv.ui

import com.example.moviles1felixjv.domain.domain.modelo.Videojuego

data class MainState(
    val videojuego: Videojuego? = null,
    val error: String? = null
)
