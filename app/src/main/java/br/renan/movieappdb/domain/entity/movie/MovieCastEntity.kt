package br.renan.movieappdb.domain.entity.movie

data class MovieCastEntity(
    var adult: Boolean,
    var gender: Int,
    var id: Int,
    var knownForDepartment: String?,
    var name: String,
    var originalName: String,
    var popularity: Double,
    var profilePath: String,
    var castId: Int,
    var character: String,
    var creditId: String,
    var order: Int
)
