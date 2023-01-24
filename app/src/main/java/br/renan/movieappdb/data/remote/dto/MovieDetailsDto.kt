package br.renan.movieappdb.data.remote.dto

import com.squareup.moshi.Json

data class MovieDetailsDto(
    @field:Json(name = "adult")
    var adult: Boolean,
    @field:Json(name = "backdrop_path")
    var backdropPath: String,
    @field:Json(name = "budget")
    var budget: Int,
    @field:Json(name = "homepage")
    var homePage: String,
    @field:Json(name = "id")
    var id: Int,
    @field:Json(name = "imdb_id")
    var imdbId: String,
    @field:Json(name = "original_language")
    var originalLanguage: String,
    @field:Json(name = "original_title")
    var originalTitle: String,
    @field:Json(name = "overview")
    var overview: String,
    @field:Json(name = "popularity")
    var popularity: Double,
    @field:Json(name = "poster_path")
    var posterPath: String,
    @field:Json(name = "release_date")
    var releaseDate: String,
    @field:Json(name = "status")
    var status: String,
    @field:Json(name = "title")
    var title: String,
    @field:Json(name = "video")
    var video: Boolean,
    @field:Json(name = "vote_average")
    var voteAverage: Double,
    @field:Json(name = "vote_count")
    var voteCount: Int,
    @field:Json(name = "genres")
    var genres: MutableList<MovieGenreDto>,
    @field:Json(name = "production_companies")
    var productionCompanies: MutableList<MovieProductionCompanyDto>,
    @field:Json(name = "production_countries")
    var productionCountries: MutableList<MovieProductionCountryDto>,
    @field:Json(name = "credits")
    var credits: MovieCreditDto,
    @field:Json(name = "images")
    var images: MovieImagesDto,
)
