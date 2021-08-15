package com.example.filmkotlinretrofitornek.ApiServis

class ApiUtils {
    companion object{
        val URL="https://microwebservice.net/ecodation/ibrahim/filmlerKotlin/"
        fun getFilmDao():FilmDao{
            return RetrofitClient.getRetrofit(URL).create(FilmDao::class.java)
        }
    }
}