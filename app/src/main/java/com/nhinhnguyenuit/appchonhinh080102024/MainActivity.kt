package com.nhinhnguyenuit.appchonhinh080102024

import android.content.Intent
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.newSingleThreadContext
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
//        imgUserSelect?.setOnClickListener {
//            val intent = Intent(this, MainActivity2::class.java)
//            startActivity(intent)
//        }
//        val imageResId = intent.getIntExtra("IMAGE_RES_ID", R.drawable.nophoto)
//        imgUserSelect?.setImageDrawable(ContextCompat.getDrawable(this, imageResId))
//        Log.d("nhinhnv", imageResId.toString())
        imgUserSelect?.setOnClickListener {
            val intent = Intent(this@MainActivity, ListAnimalActivity::class.java)
            launcherListAnimal.launch(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_random -> setImageRandom(imgRandom)
            R.id.item_share_facebook -> setImageRandom(imgUserSelect)
        }
        return true
    }

    private fun setImageRandom(imageView: ImageView?) {
        imageView ?: return
        val indexRandom = Random.nextInt(arrNameAnimals.size)
        val resourceRandom =
            resources.getIdentifier(arrNameAnimals[indexRandom], "drawable", packageName)
        imageView.setImageResource(resourceRandom)
    }

    private val launcherListAnimal =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val resource = result.data?.getIntExtra("resource", 0) ?: return@registerForActivityResult
                if (resource == 0) return@registerForActivityResult
                imgUserSelect?.setImageResource(resource)
            }
        }

}