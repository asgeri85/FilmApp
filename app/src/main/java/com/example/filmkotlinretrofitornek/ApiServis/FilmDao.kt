package com.example.filmkotlinretrofitornek.ApiServis

import com.example.filmkotlinretrofitornek.Film
import com.example.filmkotlinretrofitornek.Kategori
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface FilmDao {
    @GET("kategori.php")
    fun tumKategori():Call<List<Kategori>>

    @POST("kategoriFilm.php")
    @FormUrlEncoded
    fun film(@Field("id") id:Int):Call<List<Film>>
}