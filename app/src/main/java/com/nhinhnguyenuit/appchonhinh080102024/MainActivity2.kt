package com.nhinhnguyenuit.appchonhinh080102024

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    private var gridView: GridView? = null
    private val arrNameAnimals by lazy {
        resources.getStringArray(R.array.array_animal)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        gridView = findViewById(R.id.grid_view_select)

        //Map to list<Int>
        val listAnimal = arrNameAnimals.map {name ->
            val resId = resources.getIdentifier(name, "drawable", packageName)
            resId
        }.filter { it != 0 }

        val adapter = GridViewAdapter(this, listAnimal)
        gridView?.adapter = adapter
    }
}