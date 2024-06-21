package navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import presentation.home.HomeScreen
import presentation.home.HomeViewModel
import presentation.splash.SplashScreen

@Composable
fun ClashGuideNavigation(
    innerPadding: PaddingValues,
    homeViewModel: HomeViewModel
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Route.SPLASH_SCREEN.name
    ) {
        composable(
            route = Route.SPLASH_SCREEN.name,
            enterTransition = {
                fadeIn(
                    animationSpec = tween(durationMillis = 800)
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(durationMillis = 800)
                )
            }
        ) {
            SplashScreen(
                innerPadding = innerPadding,
                navigateToHome = {
                    navController.navigate(Route.HOME_SCREEN.name)
                }
            )
        }

        composable(
            route = Route.HOME_SCREEN.name,
            exitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(durationMillis = 800)
                )
            }
        ) {
            val uiState by homeViewModel.uiState.collectAsState()

            HomeScreen(
                innerPadding = innerPadding,
                uiState = uiState,
                onGameClick = { },
                onAboutClick = { },
                onMenuClick = { },
                navigateToDetail = { }
            )
        }
    }
}