package com.example.filmkotlinretrofitornek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.filmkotlinretrofitornek.Adapters.KategoriAdapter
import com.example.filmkotlinretrofitornek.ApiServis.ApiUtils
import com.example.filmkotlinretrofitornek.ApiServis.FilmDao
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var dao:FilmDao
    private lateinit var adapter: KategoriAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbarHome.title="Kategoriler"
        setSupportActionBar(toolbarHome)
        rvHome.setHasFixedSize(true)
        rvHome.layoutManager=LinearLayoutManager(this)
        dao=ApiUtils.getFilmDao()
        kategori()
    }

    fun kategori(){
        dao.tumKategori().enqueue(object :Callback<List<Kategori>>{
            override fun onResponse(call: Call<List<Kategori>>, response: Response<List<Kategori>>){
                if (response.body()!= null && response.isSuccessful){
                    val liste=response.body()
                    adapter= KategoriAdapter(this@MainActivity,liste!!)
                    rvHome.adapter=adapter
                }
            }

            override fun onFailure(call: Call<List<Kategori>>, t: Throwable) {
               Log.e("hata","400")
            }
        })
    }
}