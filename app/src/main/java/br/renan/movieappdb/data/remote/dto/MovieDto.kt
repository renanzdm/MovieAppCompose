package br.renan.movieappdb.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class MovieDto(
    @field:Json(name = "page")
    var page:Int,
    @field:Json(name = "total_results")
    var totalResults: Int,
    @field:Json(name = "total_pages")
    var totalPages: Int,
    @field:Json(name = "results")
    var moviesData: List<MovieDataDto>




)
