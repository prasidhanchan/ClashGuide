package navigation

import androidx.compose.animation.AnimatedContentTransitionScope.SlideDirection
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import presentation.screens.about.AboutScreen
import presentation.screens.detail.DetailScreen
import presentation.screens.game.GameScreen
import presentation.screens.home.HomeScreen
import presentation.screens.home.HomeViewModel
import presentation.screens.purchase.PurchaseScreen
import presentation.screens.splash.SplashScreen
import java.net.URLEncoder

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
                fadeIn(animationSpec = tween(durationMillis = 800))
            },
            exitTransition = {
                fadeOut(animationSpec = tween(durationMillis = 800))
            }
        ) {
            SplashScreen(
                innerPadding = innerPadding,
                navigateToHome = {
                    navController.navigate(Route.HOME_SCREEN.name)
                }
            )
        }

        composable(route = Route.HOME_SCREEN.name) {
            val uiState by homeViewModel.uiState.collectAsState()

            HomeScreen(
                innerPadding = innerPadding,
                uiState = uiState,
                onGameClick = {
                    navController.navigate(Route.GAME_SCREEN.name)
                },
                onAboutClick = {
                    navController.navigate(Route.ABOUT_SCREEN.name)
                },
                navigateToDetail = { troop ->
                    if (troop.isSuperTroop && !uiState.hasPurchasedPremium) {
                        navController.navigate(Route.PURCHASE_SCREEN.name)
                    } else {
                        val encodedImage = URLEncoder.encode(troop.image, Charsets.UTF_8)
                        navController.navigate("${Route.DETAIL_SCREEN}/${troop.name}/${troop.description}/${encodedImage}")
                    }
                }
            )
        }

        composable(
            route = "${Route.DETAIL_SCREEN.name}/{name}/{description}/{image}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                },
                navArgument("description") {
                    type = NavType.StringType
                },
                navArgument("image") {
                    type = NavType.StringType
                }
            ),
            enterTransition = {
                slideIntoContainer(
                    towards = SlideDirection.Left,
                    animationSpec = tween(durationMillis = 500)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    towards = SlideDirection.Right,
                    animationSpec = tween(durationMillis = 500)
                )
            }
        ) { backStack ->
            val name = backStack.arguments?.getString("name")
            val description = backStack.arguments?.getString("description")
            val image = backStack.arguments?.getString("image")

            DetailScreen(
                innerPadding = innerPadding,
                name = name!!,
                description = description!!,
                image = image!!,
                onBackPress = { navController.popBackStack() }
            )
        }

        composable(
            route = Route.PURCHASE_SCREEN.name,
            enterTransition = {
                slideIntoContainer(
                    towards = SlideDirection.Left,
                    animationSpec = tween(durationMillis = 500)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    towards = SlideDirection.Right,
                    animationSpec = tween(durationMillis = 500)
                )
            }
        ) {
            val uiState by homeViewModel.uiState.collectAsState()

            PurchaseScreen(
                innerPadding = innerPadding,
                onPurchasePress = homeViewModel::setHasPurchasedPremium,
                loading = uiState.isLoading,
                hasPurchasedPremium = uiState.hasPurchasedPremium,
                onBackPress = { navController.popBackStack() }
            )
        }

        composable(
            route = Route.GAME_SCREEN.name,
            enterTransition = {
                slideIntoContainer(
                    towards = SlideDirection.Left,
                    animationSpec = tween(durationMillis = 500)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    towards = SlideDirection.Right,
                    animationSpec = tween(durationMillis = 500)
                )
            }
        ) {
            GameScreen(
                innerPadding = innerPadding,
                onBackPress = { navController.popBackStack() }
            )
        }

        composable(
            route = Route.ABOUT_SCREEN.name,
            enterTransition = {
                slideIntoContainer(
                    towards = SlideDirection.Left,
                    animationSpec = tween(durationMillis = 500)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    towards = SlideDirection.Right,
                    animationSpec = tween(durationMillis = 500)
                )
            }
        ) {
            AboutScreen(
                innerPadding = innerPadding,
                onBackPress = { navController.popBackStack() }
            )
        }
    }
}