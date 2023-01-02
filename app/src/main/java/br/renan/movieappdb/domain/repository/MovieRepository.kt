package br.renan.movieappdb.domain.repository

import br.renan.movieappdb.data.remote.dto.MovieDto
import br.renan.movieappdb.domain.entity.MovieEntity
import br.renan.movieappdb.domain.util.Resource
import retrofit2.http.Query

interface MovieRepository {

    suspend fun getPopularMovies(page:Int): Resource<MovieEntity>


}