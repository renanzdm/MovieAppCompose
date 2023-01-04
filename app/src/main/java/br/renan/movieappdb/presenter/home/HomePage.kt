package br.renan.movieappdb.presenter.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.renan.movieappdb.domain.entity.MovieDataEntity
import br.renan.movieappdb.domain.entity.MovieEntity
import br.renan.movieappdb.presenter.utils.AutoResizeText
import coil.compose.AsyncImage
import org.koin.androidx.compose.koinViewModel
import java.time.format.DateTimeFormatter


@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = "Home", fontSize = 18.sp) }, contentColor = Color.White
    )
}


@Composable
fun MainScreen(homeViewModel: HomeViewModel = koinViewModel()) {
    Scaffold(
        topBar = { TopBar() },
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            if(homeViewModel.state.videoEntity!=null) {
                ListMoviesPopular(homeViewModel.state.videoEntity!!)
            }
        }
    }
}


@Composable
fun ListMoviesPopular(movieEntity: MovieEntity) {
    LazyRow(content = {
        items(movieEntity.moviesData.size) { index->
            CardMovie(movie = movieEntity.moviesData[index])
        }

    })
}


@Composable
fun CardMovie(movie:MovieDataEntity) {
    Box(
        modifier = Modifier
            .height(220.dp)
            .width(160.dp).padding(horizontal = 8.dp), contentAlignment = Alignment.TopCenter
    ) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top) {
            AsyncImage(
                model = movie.posterPath,
                contentDescription = movie.originalTitle,
                modifier = Modifier.height(200.dp).fillMaxWidth()
            )
            Text(text = movie.title, fontSize = 8.sp)
            Text(text = movie.releaseDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), fontSize = 8.sp)
        }

    }


}


@Preview()
@Composable
fun ButtonCategoryPreview() {
    val buttons = listOf("Populares", "Novidades", "Novidades", "Novidades", "Novidades")
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        this.items(buttons) { b ->
            Button(
                onClick = {}, shape = CircleShape, colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = Color.Gray, disabledContentColor = Color.White
                )
            ) {
                Text(text = b, color = Color.DarkGray)
            }
        }
    }
}

