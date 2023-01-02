package br.renan.movieappdb.presenter.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.renan.movieappdb.domain.repository.MovieRepository
import br.renan.movieappdb.domain.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    var state by mutableStateOf(HomeState())
        private set

    fun getPopularMovies(page: Int) {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true, error = null
            )
            movieRepository.getPopularMovies(page).let { movies ->
                state = when (movies) {
                    is Resource.Success -> {
                        state.copy(
                            isLoading = false, error = null, videoEntity = movies.data
                        )
                    }
                    is Resource.Error -> {
                        state.copy(
                            isLoading = false,
                            error = movies.message,
                        )
                    }
                }

            }
        }
    }


}