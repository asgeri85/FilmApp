package com.example.filmkotlinretrofitornek

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Kategori(
    @SerializedName("kategori_ad")
    @Expose
    val kategoriAd: String,
    @SerializedName("id")
    @Expose
    val id: Int
):Serializable {
}