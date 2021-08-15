package com.example.filmkotlinretrofitornek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detay.*

class DetayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)
        val film=intent.getSerializableExtra("film") as Film
        Picasso.get().load(film.filmResim).into(imageViewDetay)
        textViewDetayAd.text=film.filmAd
        textViewYil.text=film.filmYil
        textViewYOnetmen.text=film.yonetmenAd
    }
}