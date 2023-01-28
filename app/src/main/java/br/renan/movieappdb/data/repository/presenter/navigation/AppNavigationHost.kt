package br.renan.movieappdb.data.repository.presenter.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import br.renan.movieappdb.data.repository.presenter.home.HomeScreen
import br.renan.movieappdb.data.repository.presenter.home.moviedetails.MovieDetailsScreen


sealed class AppRoutes {
    companion object {
        const val homeRoute: String = "home"
        const val movieDetailsRoute: String = "movieDetails"
        
    }
}

@Composable
fun AppNavigationHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = AppRoutes.homeRoute
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        
        composable(AppRoutes.homeRoute) {
            HomeScreen(navHostController = navController)
        }
        composable("${AppRoutes.movieDetailsRoute}/{movie_id}") {
            MovieDetailsScreen(
                movieId = it.arguments?.getString("movie_id"),
                navHostController = navController
            )
        }
        
        
    }
}
//fun NavGraphBuilder.homeGraph(navController: NavHostController) {
//    navigation(startDestination = AppRoutes.movieDetailsRoute, route = AppRoutes.movieDetailsRoute) {
//
//
//    }
//}

