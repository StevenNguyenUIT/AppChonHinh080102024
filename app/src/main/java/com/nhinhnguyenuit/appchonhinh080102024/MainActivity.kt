package com.nhinhnguyenuit.appchonhinh080102024

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Random

class MainActivity : AppCompatActivity() {
    private lateinit var imvRandom: ImageView
    private var listImage: MutableList<Int> = mutableListOf(
        R.drawable.bo,
        R.drawable.bocanhcung,
        R.drawable.bongua,
        R.drawable.cachep,
        R.drawable.cadia,
        R.drawable.chimcanhcut,
        R.drawable.cho,
        R.drawable.chodom,
        R.drawable.chuonchuon,
        R.drawable.ech,
        R.drawable.heo,
        R.drawable.khi,
        R.drawable.meoden,
        R.drawable.meolucky,
        R.drawable.meotrang,
        R.drawable.rua,
        R.drawable.soi,
        R.drawable.voi
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        imvRandom = findViewById(R.id.image_view_random)
        imvRandom.setOnClickListener {
            val randomIndex = kotlin.random.Random.nextInt(listImage.size)
            imvRandom.setImageResource(listImage[randomIndex])
        }
    }
}