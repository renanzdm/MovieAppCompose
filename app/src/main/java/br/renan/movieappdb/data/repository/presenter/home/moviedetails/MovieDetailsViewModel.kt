package br.renan.movieappdb.data.repository.presenter.home.moviedetails

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.renan.movieappdb.domain.repository.MovieRepository
import br.renan.movieappdb.data.repository.presenter.utils.Resource
import kotlinx.coroutines.launch

class MovieDetailsViewModel(private val movieRepository: MovieRepository, movieId: String?) : ViewModel() {
  var state by mutableStateOf(MovieDetailsState())
    init {
        onStart(movieId)
    }
    
    private fun onStart(movieId: String?) {
        if (movieId != null) {
            getMovieDetails(movieId = movieId.toInt())
        }
    }
    
    private fun getMovieDetails(movieId: Int) {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true, error = null
            )
            movieRepository.getMovieDetails(
                movieId = movieId,
                customParams = listOf("images,credits")
            ).let {
                state = when (it) {
                    is Resource.Success -> {
                        state.copy(
                            isLoading = false,
                            error = null,
                            movieDetailsEntity = it.data
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