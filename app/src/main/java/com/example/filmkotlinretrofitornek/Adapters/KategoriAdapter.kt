package com.example.filmkotlinretrofitornek.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.filmkotlinretrofitornek.FilmActivity
import com.example.filmkotlinretrofitornek.Kategori
import com.example.filmkotlinretrofitornek.R
import com.example.filmkotlinretrofitornek.databinding.CardKategoriBinding

class KategoriAdapter(var mContex:Context,var liste:List<Kategori>):
    RecyclerView.Adapter<KategoriAdapter.AdapterTutucu>(){
    inner class AdapterTutucu(var card:CardKategoriBinding):RecyclerView.ViewHolder(card.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterTutucu {
        val tasarim=DataBindingUtil.inflate<CardKategoriBinding>(LayoutInflater.from(mContex), R.layout.card_kategori,parent,false)
        return AdapterTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: AdapterTutucu, position: Int) {
        holder.card.k=liste[position]
        holder.card.cardCategori.setOnClickListener {
            val intent=Intent(mContex,FilmActivity::class.java)
            intent.putExtra("kategori",liste[position])
            mContex.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return liste.size
    }

}