package br.renan.movieappdb.data.mappers

import br.renan.movieappdb.data.remote.dto.MovieDto
import br.renan.movieappdb.domain.entity.MovieDataEntity
import br.renan.movieappdb.domain.entity.MovieEntity
import java.time.LocalDate

fun MovieDto.toMovieEntity(): MovieEntity {
    return MovieEntity(
        totalPages = totalPages,
        totalResults = totalResults,
        page = page,
        moviesData = moviesData.map { dto ->
            MovieDataEntity(
                adult = dto.adult,
                genresId = dto.genresId,
                hasVideo = dto.hasVideo,
                id = dto.id,
                backdropPathImage = dto.backdropPathImage,
                originalLanguage = dto.originalLanguage,
                originalTitle = dto.originalTitle,
                overview = dto.overview,
                popularity = dto.popularity,
                posterPath ="https://image.tmdb.org/t/p/w500/${dto.posterPath}",
                releaseDate = LocalDate.parse(dto.releaseDate),
                title = dto.title,
                voteAverage = dto.voteAverage,
                voteCount = dto.voteCount
            )
        }.toMutableList()
    )


}