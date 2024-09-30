package com.example.moviles1felixjv.ui

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.moviles1felixjv.R
import com.example.moviles1felixjv.data.Repository
import com.example.moviles1felixjv.databinding.ActivityMainBinding
import com.example.moviles1felixjv.domain.domain.usecases.videojuegos.AddVideojuego
import com.example.moviles1felixjv.domain.domain.usecases.videojuegos.GetVideojuego
import com.example.moviles1felixjv.util.StringProvider
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels{

        MainViewModelFactory(
            StringProvider.instance(this),
            AddVideojuego(videojuego: Videojuego),
            GetVideojuego(Repository(assets.open())),
        )

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var binding = ActivityMainBinding.inflate(layoutInflater).apply{
            setContentView(root);
        }
        var name : TextInputLayout = binding.textInputLayout

        var button : Button = binding.button
       button.setOnClickListener{
            Toast.makeText(this, name.text, Toast.LENGTH_LONG).show()
        }
        //no me deja usar text en name.text
    }
}