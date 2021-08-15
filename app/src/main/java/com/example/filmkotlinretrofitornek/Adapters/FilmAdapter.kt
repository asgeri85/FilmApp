package com.example.filmkotlinretrofitornek.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.filmkotlinretrofitornek.DetayActivity
import com.example.filmkotlinretrofitornek.Film
import com.example.filmkotlinretrofitornek.R
import com.example.filmkotlinretrofitornek.databinding.CardFilmBinding
import com.squareup.picasso.Picasso

class FilmAdapter(var mContext:Context,var filmList: List<Film>):
    RecyclerView.Adapter<FilmAdapter.FilmTutucu>() {
    inner class FilmTutucu(var view:CardFilmBinding):RecyclerView.ViewHolder(view.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmTutucu {
        val tasarim=DataBindingUtil.inflate<CardFilmBinding>(LayoutInflater.from(mContext),R.layout.card_film,parent,false)
        return FilmTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: FilmTutucu, position: Int) {
        holder.view.film=filmList[position]
        Picasso.get().load(filmList[position].filmResim).resize(200,300).into(holder.view.imageViewCard);
        holder.view.cardFilm.setOnClickListener {
            val intent=Intent(mContext,DetayActivity::class.java)
            intent.putExtra("film",filmList[position])
            mContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
      return filmList.size
    }

}