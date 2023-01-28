package br.renan.movieappdb.domain.entity.movie

import java.time.LocalDate

data class MovieDetailsEntity(
    var adult: Boolean,
    var backdropPath : String,
    var budget: Int,
    var homePage: String,
    var id: Int,
    var imdbId: String,
    var originalLanguage:String,
    var originalTitle:String,
    var overview:String,
    var popularity: Double,
    var posterPath:String,
    var releaseDate : LocalDate,
    var status:String,
    var title:String,
    var video:Boolean,
    var voteAverage:Double,
    var voteCount:Int,
    var genres:List<MovieGenreEntity>,
    var images:MovieImagesEntity,
    var credits:MovieCreditEntity,
    var productionCompanies:List<MovieProductionCompanyEntity>,
    var productionCountry:List<MovieProductionCountryEntity>,
    
)
