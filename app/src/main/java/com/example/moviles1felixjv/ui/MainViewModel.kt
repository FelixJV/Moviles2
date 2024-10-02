package com.example.moviles1felixjv.ui

import com.example.moviles1felixjv.util.StringProvider
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviles1felixjv.R
import com.example.moviles1felixjv.domain.domain.modelo.Videojuego
import com.example.moviles1felixjv.domain.domain.usecases.videojuegos.AddVideojuego
import com.example.moviles1felixjv.domain.domain.usecases.videojuegos.GetVideojuego
import com.example.moviles1felixjv.util.Constantes


class MainViewModel(
    private val stringProvider: StringProvider,
    private val addVideojuegoUC: AddVideojuego,
    private val getVideojuegoUC: GetVideojuego,
) : ViewModel() {

    private var indice =0
    private val _uiState = MutableLiveData(MainState())
    val uiState: LiveData<MainState> get() = _uiState


    init {
        _uiState.value = MainState(videojuego=this.getVideojuegoUC()[0])
    }

    fun addVideojuego(videojuego: Videojuego) {

        if (!addVideojuegoUC(videojuego)) {
            _uiState.value = MainState(
                videojuego = _uiState.value.let{videojuego},
                error = stringProvider.getString(R.string.nombre),
            )
            _uiState.value = _uiState
                .value?.copy(error = Constantes.ERROR)
        }
    }

    fun getVideojuegos(id: Int) {
        val videojuegos = getVideojuegoUC()

        if (videojuegos.size < id || id < 0) {
            _uiState.value = _uiState.value?.copy(error = "error")

        } else
            _uiState.value = _uiState.value?.copy(videojuego = videojuegos[id])


    }

    fun errorMostrado() {
        _uiState.value = _uiState.value?.copy(error = null)
    }

}


/**
 * Factory class to instantiate the [ViewModel] instance.
 */
class MainViewModelFactory(
    private val stringProvider: StringProvider,
    private val addVideojuegoUC: AddVideojuego,
    private val getVideojuegoUC: GetVideojuego,

    ) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(
                stringProvider,
                addVideojuegoUC,
                getVideojuegoUC,
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}