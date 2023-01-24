package br.renan.movieappdb.data.repository

import br.renan.movieappdb.BuildConfig
import br.renan.movieappdb.data.mappers.toMovieDetailsEntity
import br.renan.movieappdb.data.mappers.toMovieEntity
import br.renan.movieappdb.data.remote.api.MovieAppApi
import br.renan.movieappdb.domain.entity.movie.MovieDetailsEntity
import br.renan.movieappdb.domain.entity.movie.MovieEntity
import br.renan.movieappdb.domain.repository.MovieRepository
import br.renan.movieappdb.presenter.utils.Resource

class MovieRepositoryImpl(private val movieAppApi: MovieAppApi) : MovieRepository {
    override suspend fun getPopularMovies(page: Int): Resource<MovieEntity> {
     return try {
            Resource.Success(
                data = movieAppApi.getPopularMovies(page, apiKey = BuildConfig.apiKey).toMovieEntity()
            )
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
    
    override suspend fun getMovieDetails(
        customParams: List<String>,
        movieId: Int
    ): Resource<MovieDetailsEntity> {
        return try {
            Resource.Success(
                data = movieAppApi.getMovieDetails( apiKey = BuildConfig.apiKey, customParam = customParams,id= movieId).toMovieDetailsEntity()
            )
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}