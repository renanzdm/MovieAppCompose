package br.renan.movieappdb.presenter.home.moviedetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf
import java.time.format.DateTimeFormatter

@Composable
fun MovieDetailsScreen(
    movieId: String?,
    movieDetailsViewModel: MovieDetailsViewModel = koinViewModel { parametersOf(movieId) },
    navHostController: NavHostController

) {
    Scaffold(
        topBar = {
            MyAppBar(movieDetailsViewModel, navHostController)
        },
    ) { padding ->
        Box(modifier = Modifier.fillMaxSize()) {
            if (movieDetailsViewModel.state.isLoading) {
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
            ContentScreen(state = movieDetailsViewModel.state)
            
            
        }
    }
    
}

@Composable
private fun MyAppBar(
    movieDetailsViewModel: MovieDetailsViewModel,
    navHostController: NavHostController
) {
    TopAppBar(title = {
        movieDetailsViewModel.state.movieDetailsEntity?.let {
            Text(
                text = it.title
            )
        }
    }, navigationIcon = {
        IconButton(content = {
            Icon(
                Icons.Filled.ArrowBack, "", tint = Color.White
            )
        }, onClick = {
            navHostController.previousBackStackEntry.let {
                navHostController.navigateUp()
            }
        }
        
        )
    }
    
    )
}

@Composable
fun ContentScreen(state: MovieDetailsState) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Spacer(modifier = Modifier.height(8.dp))
        state.movieDetailsEntity?.let {
            AsyncImage(
                model = it.posterPath,
                contentDescription = it.originalTitle,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(300.dp)
                    .padding(end = 8.dp)
                    .clip(RoundedCornerShape(12.dp)),
            )
                   Text(
                        text = it.title,
                        style = TextStyle(fontSize = 32.sp, fontWeight = FontWeight.Bold)
                    )
                    Text(
                        text = it.releaseDate.format(
                            DateTimeFormatter.ofPattern("dd-MM-yyyy")
                        ), style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    )
                    Text(
                        text = "Sinopse", style = TextStyle(
                            fontSize = 16.sp, fontWeight = FontWeight.Bold
                        )
                    )
                    Text(text = it.overview)
            LazyRow {
                items(items = state.movieDetailsEntity.genres) {
                    Box(
                        modifier = Modifier
                            .height(40.dp)
                            .padding(4.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(MaterialTheme.colors.primary)
        
                    ) {
                        Text(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .padding(4.dp),
                            text = it.name,
                            style = TextStyle(
                                color = Color.White
                            )
                        )
                    }
                }
            }
    
        }
    }
}

