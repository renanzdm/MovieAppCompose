package br.renan.movieappdb.data.remote.dto

import com.squareup.moshi.Json

data class MovieCrewDto(
    @field:Json(name = "adult")
    var adult: Boolean,
    @field:Json(name = "gender")
    var gender: Int,
    @field:Json(name = "id")
    var id: Int,
    @field:Json(name = "known_for_department")
    var knownForDepartment: String,
    @field:Json(name = "name")
    var name: String,
    @field:Json(name = "original_name")
    var originalName: String,
    @field:Json(name = "popularity")
    var popularity: Double,
    @field:Json(name = "profile_path")
    var profilePath: String?,
    @field:Json(name = "credit_id")
    var creditId: String,
    @field:Json(name = "department")
    var department: String,
    @field:Json(name = "job")
    var job: String
)