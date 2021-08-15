package com.example.filmkotlinretrofitornek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.filmkotlinretrofitornek.Adapters.FilmAdapter
import com.example.filmkotlinretrofitornek.ApiServis.ApiUtils
import com.example.filmkotlinretrofitornek.ApiServis.FilmDao
import kotlinx.android.synthetic.main.activity_film.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilmActivity : AppCompatActivity() {
    private lateinit var dao:FilmDao
    private lateinit var adapter:FilmAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film)
        val kategori=intent.getSerializableExtra("kategori") as Kategori
        toolbarFilm.title=kategori.kategoriAd
        setSupportActionBar(toolbarFilm)
        rvFilm.setHasFixedSize(true)
        rvFilm.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        dao=ApiUtils.getFilmDao()
        filmGetir(kategori.id)
    }

    fun filmGetir(id:Int){
        dao.film(id).enqueue(object : Callback<List<Film>>{
            override fun onResponse(call: Call<List<Film>>, response: Response<List<Film>>) {
                if (response.body()!= null && response.isSuccessful){
                    val liste=response.body()
                    adapter=FilmAdapter(this@FilmActivity,liste!!)
                    rvFilm.adapter=adapter
                }else{
                    Toast.makeText(applicationContext,"Film yok",Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<List<Film>>, t: Throwable) {
                Log.e("Hata","400")
            }
        })
    }
}