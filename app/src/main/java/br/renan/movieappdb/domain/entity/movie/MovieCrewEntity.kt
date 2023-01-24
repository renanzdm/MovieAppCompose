package br.renan.movieappdb.domain.entity.movie

data class MovieCrewEntity(
    var adult: Boolean,
    var gender: Int,
    var id: Int,
    var knownForDepartment: String,
    var name: String,
    var originalName: String,
    var popularity: Double,
    var profilePath: String?,
    var creditId: String,
    var department: String,
    var job: String
)