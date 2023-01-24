package br.renan.movieappdb.data.mappers

import br.renan.movieappdb.data.remote.dto.MovieDetailsDto
import br.renan.movieappdb.data.remote.dto.MovieDto
import br.renan.movieappdb.domain.entity.movie.*
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
                posterPath = "https://image.tmdb.org/t/p/w500/${dto.posterPath}",
                releaseDate = LocalDate.parse(dto.releaseDate),
                title = dto.title,
                voteAverage = dto.voteAverage,
                voteCount = dto.voteCount
            )
        }.toMutableList()
    )
    
}


fun MovieDetailsDto.toMovieDetailsEntity(): MovieDetailsEntity {
    return MovieDetailsEntity(
        title = title,
        voteCount = voteCount,
        voteAverage = voteAverage,
        releaseDate = releaseDate,
        posterPath = "https://image.tmdb.org/t/p/w500/${posterPath}",
        popularity = popularity,
        overview = overview,
        originalTitle = originalTitle,
        originalLanguage = originalLanguage,
        id = id,
        adult = adult,
        backdropPath = backdropPath,
        budget = budget,
        homePage = homePage,
        imdbId = imdbId,
        status = status,
        video = video,
        genres = genres.map { dto ->
            MovieGenreEntity(
                id = dto.id,
                name = dto.name
            )
        }.toList(),
        credits = MovieCreditEntity(
            cast = credits.cast.map { cast ->
                MovieCastEntity(
                    name = cast.name,
                    id = cast.id,
                    adult = cast.adult,
                    popularity = cast.popularity,
                    castId = cast.castId,
                    character = cast.character,
                    creditId = cast.creditId,
                    gender = cast.gender,
                    knownForDepartment = cast.knownForDepartment,
                    order = cast.order,
                    originalName = cast.originalName,
                    profilePath = "https://image.tmdb.org/t/p/w500/${cast.profilePath}"
                
                )
            }.toList(),
            crew = credits.crew.map { crew ->
                MovieCrewEntity(
                    profilePath = "https://image.tmdb.org/t/p/w500/${crew.profilePath}",
                    originalName = crew.originalName,
                    knownForDepartment = crew.knownForDepartment,
                    gender = crew.gender,
                    creditId = crew.creditId,
                    popularity = crew.popularity,
                    adult = crew.adult,
                    name = crew.name,
                    id = crew.id,
                    department = crew.department,
                    job = crew.job
                )
            }.toList(),
        ),
        images = MovieImagesEntity(
            
            backdrops = images.backdrops.map { back ->
                ImageConfigs(
                    voteAverage = back.voteAverage,
                    voteCount = back.voteCount,
                    aspectRatio = back.aspectRatio,
                    filePath = "https://image.tmdb.org/t/p/w500/${back.filePath}"
                )
            }.toList(),
            posters = images.posters.map { back ->
                ImageConfigs(
                    voteAverage = back.voteAverage,
                    voteCount = back.voteCount,
                    aspectRatio = back.aspectRatio,
                    filePath = "https://image.tmdb.org/t/p/w500/${back.filePath}"
                )
            }.toList(),
            logos = images.logos.map { back ->
                ImageConfigs(
                    voteAverage = back.voteAverage,
                    voteCount = back.voteCount,
                    aspectRatio = back.aspectRatio,
                    filePath = "https://image.tmdb.org/t/p/w500/${back.filePath}"
                )
            }.toList(),
        ),
        productionCompanies = productionCompanies.map { dto ->
            MovieProductionCompanyEntity(
                id = dto.id,
                name = dto.name,
                logoPath = "https://image.tmdb.org/t/p/w500/${dto.logoPath}",
                originalCountry = dto.originalCountry
            )
            
        }.toList(),
        productionCountry = productionCountries.map { dto ->
            MovieProductionCountryEntity(
                name = dto.name,
                iso = dto.iso,
            )
            
        }.toList()
    
    )
    
    
}