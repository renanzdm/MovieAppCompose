package br.renan.movieappdb.domain.di

import br.renan.movieappdb.data.remote.api.MovieAppApi
import br.renan.movieappdb.data.repository.MovieRepositoryImpl
import br.renan.movieappdb.domain.repository.MovieRepository
import br.renan.movieappdb.presenter.home.HomeViewModel
import br.renan.movieappdb.presenter.home.moviedetails.MovieDetailsViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.parameter.ParametersHolder
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val appModule = module {
    val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }).build()
    
    single<MovieAppApi> {
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create(MovieAppApi::class.java)
    }
    single<MovieRepository> {
        MovieRepositoryImpl(get())
    }
    viewModel {
        HomeViewModel(get())
    }
    viewModel {params->
        MovieDetailsViewModel(get(), params.get())
    }
    
}