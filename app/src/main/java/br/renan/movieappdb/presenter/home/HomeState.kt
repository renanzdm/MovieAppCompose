package br.renan.movieappdb.presenter.home

import br.renan.movieappdb.domain.entity.MovieEntity

data class HomeState(
    val videoEntity: MovieEntity?=null,
    val isLoading: Boolean = false,
    val error: String? = null
)
