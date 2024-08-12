package com.nhinhnguyenuit.appchonhinh080102024

import android.os.Bundle
import android.widget.ImageView
import android.widget.TableLayout
import android.widget.TableRow
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListAnimalActivity : AppCompatActivity() {

    private var tableLayout: TableLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_animal)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.table_layout_list_animal)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        displayListAnimal()
    }

    private fun displayListAnimal() {
        tableLayout = findViewById(R.id.table_layout_list_animal)
        // 3 col -> ImageView
        // 6 row -> tableRow
        val totalRow = 6
        val totalColumn = 3
        for (i in 0 until totalRow){
            val tableRow = TableRow(this)
            for (y in 0 until totalColumn){
                val imageView = ImageView(this)
                imageView.setImageResource(R.drawable.soi)
                tableRow.addView(imageView)
            }
            tableLayout?.addView(tableRow)
        }
    }
}