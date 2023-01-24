package br.renan.movieappdb.domain.repository

import br.renan.movieappdb.domain.entity.movie.MovieDetailsEntity
import br.renan.movieappdb.domain.entity.movie.MovieEntity
import br.renan.movieappdb.presenter.utils.Resource

interface MovieRepository {

    suspend fun getPopularMovies(page:Int): Resource<MovieEntity>
    
    suspend fun getMovieDetails(customParams:List<String>,movieId:Int):Resource<MovieDetailsEntity>


}