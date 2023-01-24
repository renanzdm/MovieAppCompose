package br.renan.movieappdb.presenter.home

import br.renan.movieappdb.domain.entity.movie.MovieDetailsEntity
import br.renan.movieappdb.domain.entity.movie.MovieEntity

data class HomeState(
    val movieEntity: MovieEntity?=null,
    val isLoading: Boolean = false,
    val error: String? = null,
)
