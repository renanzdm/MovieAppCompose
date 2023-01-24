package br.renan.movieappdb.presenter.home.moviedetails

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun MovieDetailsScreen(
    movieId: String?,
    movieDetailsViewModel: MovieDetailsViewModel = koinViewModel { parametersOf(movieId) }
) {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                movieDetailsViewModel.state.movieDetailsEntity?.let {
                    Text(
                        text = it.title
                    )
                }
            })
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
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Spacer(modifier = Modifier.height(8.dp))
                movieDetailsViewModel.state.movieDetailsEntity?.let{
               Row() {
                   AsyncImage(
                       model = it.posterPath,
                       contentDescription = it.originalTitle,
                       contentScale = ContentScale.FillBounds,
                       modifier = Modifier
                           .height(250.dp)
                           .width(200.dp)
                           .clip(RoundedCornerShape(12.dp)),
                   )
                   Column() {
                       Text(text = it.title)
                       Text(text = it.releaseDate)
                       Text(text = "Sinopse", style = TextStyle(
                           fontSize = 16.sp, fontWeight = FontWeight.Bold
                       ))
                       Text(text = it.overview)
                       
                   }
               }
               
               
                }
            }
            
        }
    }
    
    
}