package br.renan.movieappdb.data.remote.dto

import com.squareup.moshi.Json

data class  ImageConfigsDto(
    @field:Json(name = "aspect_ratio")
    var aspectRatio:Double,
    @field:Json(name = "file_path")
    var filePath: String,
    @field:Json(name = "vote_average")
    var voteAverage:Double,
    @field:Json(name = "vote_count")
    var voteCount:Int,
)
