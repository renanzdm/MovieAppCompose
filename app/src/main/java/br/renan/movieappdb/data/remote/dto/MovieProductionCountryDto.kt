package br.renan.movieappdb.data.remote.dto

import com.squareup.moshi.Json

data class MovieProductionCountryDto(
    @field:Json(name = "iso_3166_1")
    var iso:String,
    @field:Json(name = "name")
    var name:String
)
