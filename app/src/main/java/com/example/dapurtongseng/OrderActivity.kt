package com.example.dapurtongseng

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.dapurtongseng.databinding.ActivityOrderBinding

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val ivMenuPhoto: ImageView = findViewById(R.id.ivMenuPhoto)
        val tvMenuName: TextView = findViewById(R.id.tvMenuName)
        val tvMenuDesc: TextView = findViewById(R.id.tvMenuDesc)
        val tvOrderTitle: TextView = findViewById(R.id.tvOrderTitle)

        val fullName = intent.getStringExtra("FULL_NAME")
        val menuName = intent.getStringExtra("MENU_NAME")
        val menuDesc = intent.getStringExtra("MENU_DESC")
        val photoName = intent.getStringExtra("MENU_PHOTO")

        tvOrderTitle.text = "Pesanan oleh $fullName"
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
    }
}
