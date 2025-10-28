package com.example.dapurtongseng

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.dapurtongseng.databinding.ActivityOrderBinding

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        supportActionBar?.hide()

        val ivMenuPhoto: ImageView = findViewById(R.id.ivMenuPhoto)
        val tvMenuName: TextView = findViewById(R.id.tvMenuName)
        val tvMenuDesc: TextView = findViewById(R.id.tvMenuDesc)
        val tvOrderTitle: TextView = findViewById(R.id.tvOrderTitle)

        val fullName = intent.getStringExtra("FULL_NAME")
        val menuName = intent.getStringExtra("MENU_NAME")
        val menuDesc = intent.getStringExtra("MENU_DESC")
        val photoName = intent.getStringExtra("MENU_PHOTO")

        if (fullName != null && fullName.isNotEmpty()) {
            tvOrderTitle.text = "Pesanan oleh $fullName"
        } else {
            tvOrderTitle.text = "Pesanan saya"
        }
        tvMenuName.text = menuName
        tvMenuDesc.text = menuDesc

        val imageResId = resources.getIdentifier(
            photoName?.substringBefore(".jpg"),
            "drawable",
            packageName
        )

        Glide.with(this)
            .load(imageResId)
            .into(ivMenuPhoto)

        val kirimButton = findViewById<Button>(R.id.btn_kirim)
        kirimButton.setOnClickListener {
            val intent = Intent(this, AlamatActivity::class.java)
            startActivity(intent)
        }
    }
}
