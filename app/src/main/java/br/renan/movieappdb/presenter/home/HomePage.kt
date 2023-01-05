package br.renan.movieappdb.presenter.home

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.renan.movieappdb.domain.entity.MovieDataEntity
import br.renan.movieappdb.domain.entity.MovieEntity
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
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    if (homeViewModel.state.error != null) {
        LaunchedEffect(key1 = homeViewModel.state.error, block = {
            coroutineScope.launch {
                scaffoldState.snackbarHostState.showSnackbar(
                    message = "This is your message",
                    actionLabel = "Do something"
                )
            }
        }
        )
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar() },
    ) { padding ->
        Box(modifier = Modifier.fillMaxSize()) {
            if (homeViewModel.state.isLoading) {
                Box(
                    Modifier
                        .align(Alignment.Center)
                        .width(22.dp)
                        .height(22.dp)
                ) {
                    CircularProgressIndicator()
                }
            } else if (homeViewModel.state.videoEntity != null) {
                Column(modifier = Modifier.padding(padding)) {
                    ListMoviesPopular(
                        homeViewModel.state.videoEntity!!, viewModel = homeViewModel
                    )

                }
            }
        }
    }
}


@Composable
fun ListMoviesPopular(movieEntity: MovieEntity, viewModel: HomeViewModel) {
    val listState = rememberLazyListState()
    var page by remember {
        mutableStateOf(1)
    }

    LazyRow(state = listState, content = {
        items(movieEntity.moviesData.size) { index ->
            CardMovie(movie = movieEntity.moviesData[index])
        }

    })
    listState.OnBottomReached {
        page = page.inc()
        viewModel.getPopularMovies(page)
    }
}


@Composable
fun LazyListState.OnBottomReached(
    loadMore: () -> Unit
) {
    val shouldLoadMore = remember {
        derivedStateOf {
            val lastVisibleItem =
                layoutInfo.visibleItemsInfo.lastOrNull() ?: return@derivedStateOf true

            lastVisibleItem.index == layoutInfo.totalItemsCount - 1
        }
    }

    LaunchedEffect(shouldLoadMore) {
        snapshotFlow { shouldLoadMore.value }.collect {
            // if should load more, then invoke loadMore
            if (it) loadMore()
        }
    }
}

@Composable
fun CardMovie(movie: MovieDataEntity) {
    Box(
        modifier = Modifier
            .height(220.dp)
            .width(160.dp)
            .padding(horizontal = 8.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top) {
            AsyncImage(
                model = movie.posterPath,
                contentDescription = movie.originalTitle,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
            )
            Text(text = movie.title, fontSize = 8.sp)
            Text(
                text = movie.releaseDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                fontSize = 8.sp
            )
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

