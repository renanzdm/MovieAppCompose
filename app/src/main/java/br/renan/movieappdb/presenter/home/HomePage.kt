package br.renan.movieappdb.presenter.home

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.renan.movieappdb.domain.entity.MovieDataEntity
import br.renan.movieappdb.domain.entity.MovieEntity
import br.renan.movieappdb.presenter.utils.AutoResizeText
import br.renan.movieappdb.presenter.utils.IndicatorCircularRate
import br.renan.movieappdb.presenter.utils.OnBottomReached
import coil.compose.AsyncImage
import kotlinx.coroutines.launch
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
        
        Box(modifier = Modifier.fillMaxSize()) {
            if (homeViewModel.state.isLoading) {
                Box(
                    Modifier
                        .align(Alignment.Center)
                        .width(22.dp)
                        .height(22.dp)
                        .padding(padding)
                ) {
                    CircularProgressIndicator()
                }
            }
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(
                    text = "Os mais Populares",
                    style = TextStyle(fontWeight = FontWeight.Bold, color = Color.Gray),
                    fontSize = 22.sp
                )
                Divider()
                ListMoviesPopular(viewModel = homeViewModel)
            }
            
        }
    }
}


@Composable
fun ListMoviesPopular(viewModel: HomeViewModel) {
    val listState = rememberLazyListState()
    var page by remember {
        mutableStateOf(1)
    }
    if (viewModel.state.videoEntity != null) {
        
        LazyRow(state = listState, content = {
            items(
                viewModel.state.videoEntity!!.moviesData,
                key = { item -> item.id.hashCode() }) { item ->
                CardMovie(movie = item)
            }
            
        })
    }
    listState.OnBottomReached {
        page = page.inc()
        viewModel.getPopularMovies(page)
    }
}


@Composable
fun CardMovie(movie: MovieDataEntity) {
    Column(
        modifier = Modifier
            .padding(vertical = 16.dp, horizontal = 8.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = movie.posterPath,
            contentDescription = movie.originalTitle,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
        )
        Box(modifier = Modifier
            .offset(y = (-20).dp, x = (-20).dp)){
            IndicatorCircularRate(value = (movie.voteAverage / 10))
        }
        Box(modifier = Modifier.height(10.dp))
        Text(
            text = movie.title, fontSize = 14.sp, modifier = Modifier
                .width(120.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = movie.releaseDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
            fontSize = 10.sp, modifier = Modifier
                .width(120.dp)
                .align(Alignment.CenterHorizontally)
        )
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

