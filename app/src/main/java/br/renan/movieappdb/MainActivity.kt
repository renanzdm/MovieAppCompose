package br.renan.movieappdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.renan.movieappdb.presenter.home.HomeViewModel
import br.renan.movieappdb.presenter.home.MainScreen
import br.renan.movieappdb.presenter.home.MusicScreen
import br.renan.movieappdb.presenter.theme.MovieAppDbTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val homeViewModel :HomeViewModel by viewModel()
//        homeViewModel.getPopularMovies(1)
        setContent {
            MovieAppDbTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

