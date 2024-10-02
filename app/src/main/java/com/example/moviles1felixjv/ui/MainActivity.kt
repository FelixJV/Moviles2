package com.example.moviles1felixjv.ui

import android.os.Bundle
import android.widget.Adapter
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.moviles1felixjv.R
import com.example.moviles1felixjv.data.Repository
import com.example.moviles1felixjv.databinding.ActivityMainBinding
import com.example.moviles1felixjv.domain.domain.modelo.Videojuego
import com.example.moviles1felixjv.domain.domain.usecases.videojuegos.AddVideojuego
import com.example.moviles1felixjv.domain.domain.usecases.videojuegos.GetVideojuego
import com.example.moviles1felixjv.util.StringProvider
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {




    private val viewModel: MainViewModel by viewModels{

        MainViewModelFactory(
            StringProvider.instance(this),
            AddVideojuego(Repository.getInstance()),
            GetVideojuego(Repository.getInstance())
        )


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val name: TextInputLayout = binding.textInputLayout

        binding.Submit?.setOnClickListener{
            val nombreVideojuego = binding.textInputLayout.editText?.text.toString()
            val genero = binding.textInputLayout2.editText?.text.toString()
            val videojuego = Videojuego(nombreVideojuego,genero)
            viewModel.addVideojuego(videojuego)
        }
        binding.buttonizq?.setOnClickListener{

        }
    }
}