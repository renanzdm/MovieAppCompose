package br.renan.movieappdb.data.repository

import br.renan.movieappdb.data.mappers.toMovieEntity
import br.renan.movieappdb.data.remote.api.MovieAppApi
import br.renan.movieappdb.domain.entity.MovieEntity
import br.renan.movieappdb.domain.repository.MovieRepository
import br.renan.movieappdb.domain.util.Resource

class MovieRepositoryImpl(private val movieAppApi: MovieAppApi) : MovieRepository {
    override suspend fun getPopularMovies(page: Int): Resource<MovieEntity> {
     return try {
            Resource.Success(
                data = movieAppApi.getPopularMovies(page).toMovieEntity()
            )
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}