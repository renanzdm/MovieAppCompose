package br.renan.movieappdb.data.remote.dto

import com.squareup.moshi.Json

data class MovieImagesDto(
    @field:Json(name = "backdrops")
    var backdrops: List<ImageConfigsDto>,
    @field:Json(name = "logos")
    var logos: List<ImageConfigsDto>,
    @field:Json(name = "posters")
    var posters: List<ImageConfigsDto>
)






