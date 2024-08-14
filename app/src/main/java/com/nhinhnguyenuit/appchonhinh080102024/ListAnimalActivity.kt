package com.nhinhnguyenuit.appchonhinh080102024

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Collections

class ListAnimalActivity : AppCompatActivity() {

    private var tableLayout: TableLayout? = null
    private val arrNameAnimals by lazy {
        resources.getStringArray(R.array.array_animal)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_animal)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.table_layout_list_animal)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Shuffle list animals
        arrNameAnimals.shuffle()
        displayListAnimal()
    }

    private fun displayListAnimal() {
        tableLayout = findViewById(R.id.table_layout_list_animal)
        // 3 col -> ImageView
        // 6 row -> tableRow
        val totalRow = 6
        val totalColumn = 3
        var index = 0
        var resource: Int
        for (i in 0 until totalRow){
            val tableRow = TableRow(this)
            for (y in 0 until totalColumn){
                var imageView = ImageView(this)
                index = (i*3) + y
                resource = resources.getIdentifier(arrNameAnimals[index], "drawable", packageName)
                imageView.setImageResource(resource)
                imageView.tag = resource
                imageView.setOnClickListener {
//                    Toast.makeText(this@ListAnimalActivity, imageView.tag.toString(),Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@ListAnimalActivity, MainActivity::class.java)
                    intent.putExtra("resource", (imageView.tag as? Int)?:0)
                    setResult(RESULT_OK, intent)
                    finish()
                }
                tableRow.addView(imageView)
            }
            tableLayout?.addView(tableRow)
        }
    }
}