package br.renan.movieappdb.data.remote.api

import br.renan.movieappdb.data.remote.dto.MovieDetailsDto
import br.renan.movieappdb.data.remote.dto.MovieDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieAppApi {
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("page") page: Int,@Query("api_key") apiKey: String): MovieDto
    
    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String,
        @Query("append_to_response") customParam: List<String>,
    ):MovieDetailsDto
}