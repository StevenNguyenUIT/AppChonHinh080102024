package com.nhinhnguyenuit.appchonhinh080102024

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var imgRandom: ImageView? = null
    private var imgUserSelect: ImageView? = null
    private val arrNameAnimals by lazy {
        resources.getStringArray(R.array.array_animal)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        imgRandom = findViewById(R.id.image_view_random)
        imgUserSelect = findViewById(R.id.image_view_user_select)
        setImageRandom(imgRandom)
    }

    private fun setImageRandom(imageView: ImageView?) {
        imageView ?: return
        val indexRandom = Random.nextInt(arrNameAnimals.size)
        val resourceRandom =
            resources.getIdentifier(arrNameAnimals[indexRandom], "drawable", packageName)
        imgRandom?.setImageResource(resourceRandom)
    }
}