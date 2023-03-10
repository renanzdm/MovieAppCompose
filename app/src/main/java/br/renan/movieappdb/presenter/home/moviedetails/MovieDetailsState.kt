package br.renan.movieappdb.presenter.home.moviedetails

import br.renan.movieappdb.domain.entity.movie.MovieDetailsEntity

data class MovieDetailsState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val movieDetailsEntity: MovieDetailsEntity?=null
)
