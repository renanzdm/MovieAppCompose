package br.renan.movieappdb.data.remote.dto

import com.squareup.moshi.Json

data class MovieGenreDto(
    @field:Json(name = "id")
    var id:Int,
    @field:Json(name = "name")
    var name:String

)
