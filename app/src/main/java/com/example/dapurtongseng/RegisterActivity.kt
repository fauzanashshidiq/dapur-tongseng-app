package com.example.dapurtongseng

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        supportActionBar?.hide()
        val registerButton = findViewById<Button>(R.id.btn_register_submit)
        val fullNameEditText = findViewById<EditText>(R.id.et_full_name)
        registerButton.setOnClickListener {
            val fullName = fullNameEditText.text.toString()
            val intent = Intent(this, MainActivity::class.java)

            intent.putExtra("FULL_NAME", fullName)

            startActivity(intent)
            finishAffinity()
        }
    }
}