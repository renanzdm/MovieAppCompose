package br.renan.movieappdb.domain.entity.movie

import java.time.LocalDate

data class MovieDataEntity(
    var posterPath: String,
    var adult: Boolean,
    var overview: String,
    var releaseDate: LocalDate,
    var genresId: MutableList<Int>,
    var id: Int,
    var originalTitle:String,
    var originalLanguage:String,
    var title:String,
    var backdropPathImage: String?,
    var popularity:Double,
    var voteCount:Int,
    var hasVideo:Boolean,
    var voteAverage: Double

)
