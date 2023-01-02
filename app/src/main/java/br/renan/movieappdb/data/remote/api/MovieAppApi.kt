package br.renan.movieappdb.data.remote.api

import br.renan.movieappdb.data.remote.dto.MovieDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieAppApi {
    @GET("movie/popular?api_key=a7ab8a4b9565c208f0756322e0329b55")
    suspend fun getPopularMovies(@Query("page")page:Int): MovieDto
}