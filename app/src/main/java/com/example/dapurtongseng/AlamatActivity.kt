package com.example.dapurtongseng

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AlamatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alamat)

        supportActionBar?.hide()
        val alamatButton = findViewById<Button>(R.id.btn_send_submit)
        val fullNameEditText = findViewById<EditText>(R.id.et_full_name)
        alamatButton.setOnClickListener {
            val fullName = fullNameEditText.text.toString()
            val intent = Intent(this, ConfirmationActivity::class.java)

            intent.putExtra("FULL_NAME", fullName)

            startActivity(intent)
            finishAffinity()
        }
    }
}