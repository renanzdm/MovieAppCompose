package br.renan.movieappdb.data.repository.presenter.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.*
import br.renan.movieappdb.domain.entity.movie.MovieDataEntity
import br.renan.movieappdb.domain.repository.MovieRepository
import br.renan.movieappdb.data.repository.presenter.utils.Resource
import kotlinx.coroutines.launch

class HomeViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    var state by mutableStateOf(HomeState())
        private set
    
    init {
        onStart()
    }
    
    
    private fun onStart() {
        getPopularMovies(1)
    }
    
    
    fun getPopularMovies(page: Int) {
        val amountList: MutableList<MovieDataEntity> =
            state.movieEntity?.moviesData ?: mutableListOf()
        viewModelScope.launch {
            state = state.copy(
                isLoading = true, error = null
            )
            movieRepository.getPopularMovies(page).let {
                state = when (it) {
                    is Resource.Success -> {
                        if (it.data?.moviesData != null) amountList.addAll(it.data.moviesData)
                        state.copy(
                            isLoading = false,
                            error = null,
                            movieEntity = it.data?.copy(moviesData = amountList)
                        )
                    }
                    is Resource.Error -> {
                        state.copy(
                            isLoading = false,
                            error = it.message,
                        )
                    }
                }
                
            }
        }
    }
    
    
}