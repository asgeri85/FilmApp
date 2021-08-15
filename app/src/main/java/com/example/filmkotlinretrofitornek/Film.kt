package com.example.filmkotlinretrofitornek

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Film(
	@SerializedName("film_kategori_id")
	@Expose
	val filmKategoriId: String,
	@SerializedName("kategori_id")
	@Expose
	val kategoriId: String,
	@SerializedName("film_ad")
	@Expose
	val filmAd: String,
	@SerializedName("film_resim")
	@Expose
	val filmResim: String,
	@SerializedName("yonetmen_ad")
	@Expose
	val yonetmenAd: String,
	@SerializedName("film_yonetmen_id")
	@Expose
	val filmYonetmenId: String,
	@SerializedName("kategori_ad")
	@Expose
	val kategoriAd: String,
	@SerializedName("id")
	@Expose
	val id: String,
	@SerializedName("film_yil")
	@Expose
	val filmYil: String,
	@SerializedName("yonetmen_id")
	@Expose
	val yonetmenId: String):Serializable{

	}
