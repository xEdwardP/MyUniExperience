package com.example.myuniexperience.tour

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myuniexperience.R
import com.example.myuniexperience.databinding.ActivityEndTourBinding

class EndTourActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEndTourBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEndTourBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvTeamInfo.text = """
            Curso: Programacion Móvil I
            Año: 2025
            
            Integrantes:
            - Edward J. Pineda
            - Stefano A. Ponce
            - José  B. Alvarado
            - Hector J. Villeda
            - Omar A. Pinto
        """.trimIndent()
    }
}