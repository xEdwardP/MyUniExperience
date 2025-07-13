package com.example.myuniexperience.auth

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myuniexperience.R
import com.example.myuniexperience.model.User
import com.example.myuniexperience.tour.WelcomeActivity
import com.example.myuniexperience.utils.showErrorSnackbar
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView

class LoginActivity : AppCompatActivity() {
    private val users = listOf(
        User("epineda", "123", "Edward J. Pineda"),
        User("opinto", "123", "Omar A. Pinto"),
        User("jboanerges", "123", "Jose B. Alvarado")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnLogin = findViewById<MaterialButton>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val etUser = findViewById<TextInputEditText>(R.id.etUsername)
            val etPassword = findViewById<TextInputEditText>(R.id.etPassword)

            users.find { it.username == etUser.text.toString() && it.password == etPassword.text.toString() }
                ?.let { user ->
                    startActivity(
                        Intent(
                            this,
                            WelcomeActivity::class.java
                        ).apply { putExtra("FULL_NAME", user.fullName) })
                } ?: run {
                showErrorSnackbar("Credenciales inválidas")
            }
        }

    }
}
