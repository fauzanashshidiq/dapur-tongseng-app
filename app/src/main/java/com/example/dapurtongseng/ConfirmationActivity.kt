package com.example.dapurtongseng

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

class ConfirmationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        supportActionBar?.hide()
        val tvNameConfirmation: TextView = findViewById(R.id.tv_halo_name_confirmation)
        val fullName = intent.getStringExtra("FULL_NAME")

        if (fullName != null && fullName.isNotEmpty()) {
            tvNameConfirmation.text = "Halo $fullName,"
        } else {
            tvNameConfirmation.text = "Halo Pelanggan,"
        }

        val backButton = findViewById<Button>(R.id.btn_back_to_menu)
        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("FULL_NAME", fullName)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
            finish()
        }
    }
}