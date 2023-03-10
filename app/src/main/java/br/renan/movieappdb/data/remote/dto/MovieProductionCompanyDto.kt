package br.renan.movieappdb.data.remote.dto

import com.squareup.moshi.Json

data class MovieProductionCompanyDto(
    @field:Json(name = "id")
    var id:Int,
    @field:Json(name = "logo_path")
    var logoPath:String,
    @field:Json(name = "name")
    var name:String,
    @field:Json(name = "origin_country")
    var originalCountry:String
)
