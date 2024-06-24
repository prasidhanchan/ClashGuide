package presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import clashguide.composeapp.generated.resources.Res
import clashguide.composeapp.generated.resources.slider_image1
import clashguide.composeapp.generated.resources.slider_image2
import clashguide.composeapp.generated.resources.slider_image3
import clashguide.composeapp.generated.resources.super_troops
import clashguide.composeapp.generated.resources.troops
import domain.models.Troop
import domain.utils.clashBlack
import org.jetbrains.compose.resources.stringResource
import presentation.components.ClashGuideMenu
import presentation.components.Loader
import presentation.screens.home.components.ClashGuideSlider
import presentation.screens.home.components.HomeAppBar
import presentation.screens.home.components.TroopCards

@Composable
actual fun HomeScreen(
    modifier: Modifier,
    innerPadding: PaddingValues,
    uiState: UiState,
    onGameClick: () -> Unit,
    onAboutClick: () -> Unit,
    navigateToDetail: (Troop) -> Unit
) {
    val state = rememberScrollState()
    var menuState by remember { mutableStateOf(false) }

    Surface(
        modifier = modifier.fillMaxSize(),
        color = clashBlack
    ) {
        if (!uiState.isLoading) {
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(top = 30.dp, bottom = 10.dp)
                    .fillMaxSize()
                    .verticalScroll(state),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HomeAppBar(
                    onGameClick = onGameClick,
                    onAboutClick = onAboutClick,
                    onMenuClick = { menuState = true }
                )

                ClashGuideSlider(
                    sliderImages = listOf(
                        Res.drawable.slider_image1,
                        Res.drawable.slider_image2,
                        Res.drawable.slider_image3
                    )
                )

                TroopCards(
                    troops = uiState.troopList,
                    header = stringResource(Res.string.troops),
                    duration = 800,
                    navigateToDetail = navigateToDetail
                )

                TroopCards(
                    troops = uiState.superTroopList,
                    header = stringResource(Res.string.super_troops),
                    duration = 800,
                    navigateToDetail = navigateToDetail
                )
            }
        } else {
            Loader()
        }
    }

    ClashGuideMenu(
        visible = menuState,
        contentAlignment = Alignment.TopEnd,
        topPadding = 100.dp,
        endPadding = 30.dp,
        onDismiss = { menuState = false }
    )
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen(
        innerPadding = PaddingValues(),
        uiState = UiState(),
        onGameClick = { },
        onAboutClick = { },
        navigateToDetail = { }
    )
}