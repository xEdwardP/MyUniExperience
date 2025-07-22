package com.example.myuniexperience.tour

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myuniexperience.R
import com.google.android.material.button.MaterialButton

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val fullName = intent.extras?.getString("FULL_NAME").orEmpty()
        findViewById<TextView>(R.id.tvWelcome).text = getString(R.string.WelcomeTitle, fullName)

        val btnStartTour = findViewById<MaterialButton>(R.id.btnStartTour)

        btnStartTour.setOnClickListener {
            val fullName = intent.getStringExtra("FULL_NAME") ?: "Visitante"
            val intent = Intent(this, TourActivity::class.java)
            intent.putExtra("FULL_NAME", fullName)
            startActivity(intent)
        }
    }
}