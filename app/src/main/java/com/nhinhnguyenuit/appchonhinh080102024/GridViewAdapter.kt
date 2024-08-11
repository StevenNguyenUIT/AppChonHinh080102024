package com.nhinhnguyenuit.appchonhinh080102024

import android.content.Context
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import androidx.core.content.ContextCompat

class GridViewAdapter(
    private val context: Context,
    private val listAnimal: List<Int>
) : BaseAdapter() {
    override fun getCount(): Int = listAnimal.size

    override fun getItem(position: Int): Any = listAnimal[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val imageView: ImageView = convertView as? ImageView ?: ImageView(context).apply {
//            layoutParams = ViewGroup.LayoutParams(300 ,300)
//            scaleType = ImageView.ScaleType.CENTER_CROP
        }

        imageView.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java).apply {
                putExtra("IMAGE_RES_ID", listAnimal[position])
            }
            context.startActivity(intent)
        }

        val drawable = ContextCompat.getDrawable(context, listAnimal[position])
        imageView.setImageDrawable(drawable)
        return imageView
    }
}