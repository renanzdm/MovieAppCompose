package br.renan.movieappdb.domain.entity

data class MovieEntity(
    var page:Int,
    var totalResults: Int,
    var totalPages: Int,
    var moviesData: MutableList<MovieDataEntity>
)
