package br.renan.movieappdb.data.remote.dto

import com.squareup.moshi.Json

data class MovieCreditDto(
    @field:Json(name = "cast")
    var cast: List<MovieCastDto>,
    @field:Json(name = "crew")
    var crew: List<MovieCrewDto>
)









