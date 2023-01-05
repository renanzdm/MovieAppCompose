package br.renan.movieappdb.data.remote.dto

import com.squareup.moshi.Json

data class MovieDataDto(
    @field:Json(name = "poster_path")
    var posterPath: String,
    @field:Json(name = "adult")
    var adult: Boolean,
    @field:Json(name = "overview")
    var overview: String,
    @field:Json(name = "release_date")
    var releaseDate: String,
    @field:Json(name = "genre_ids")
    var genresId: MutableList<Int>,
    @field:Json(name ="id")
    var id: Int,
    @field:Json(name ="original_title")
    var originalTitle:String,
    @field:Json(name ="original_language")
    var originalLanguage:String,
    @field:Json(name ="title")
    var title:String,
    @field:Json(name ="backdrop_path")
    var backdropPathImage: String?,
    @field:Json(name ="popularity")
    var popularity:Double,
    @field:Json(name ="vote_count")
    var voteCount:Int,
    @field:Json(name ="video")
    var hasVideo:Boolean,
    @field:Json(name ="vote_average")
    var voteAverage: Double

)
