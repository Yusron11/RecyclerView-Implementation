package com.dicoding.ucl

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.ucl.Club

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imgDetail: ImageView = findViewById(R.id.img_detail)
        val tvNameDetail: TextView = findViewById(R.id.tv_name_detail)
        val tvDescriptionDetail: TextView = findViewById(R.id.tv_description_detail)


        val club = intent.getParcelableExtra<Club>("key_club")

        club?.let {
            imgDetail.setImageResource(it.photo)
            tvNameDetail.text = it.name
            tvDescriptionDetail.text = it.description
        }
    }
}
