package br.renan.movieappdb.domain.repository

import br.renan.movieappdb.domain.entity.MovieEntity
import br.renan.movieappdb.presenter.utils.Resource

interface MovieRepository {

    suspend fun getPopularMovies(page:Int): Resource<MovieEntity>


}