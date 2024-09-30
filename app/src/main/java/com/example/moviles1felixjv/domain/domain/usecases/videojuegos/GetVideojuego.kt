package com.example.moviles1felixjv.domain.domain.usecases.videojuegos

import com.example.moviles1felixjv.data.Repository

class GetVideojuego (private val repository: Repository){
    operator fun invoke() = repository.getVideojuego()

}