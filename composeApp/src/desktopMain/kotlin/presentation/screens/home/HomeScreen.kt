package presentation.screens.home

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.HorizontalScrollbar
import androidx.compose.foundation.ScrollbarStyle
import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    onMenuClick: () -> Unit,
    navigateToDetail: (Troop) -> Unit
) {
    val state = rememberScrollState()
    val troopCardState = rememberScrollState()

    Surface(
        modifier = modifier.fillMaxSize(),
        color = clashBlack
    ) {
        if (!uiState.isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                        .verticalScroll(state),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    HomeAppBar(
                        onGameClick = onGameClick,
                        onAboutClick = onAboutClick,
                        onMenuClick = onMenuClick
                    )

                    ClashGuideSlider(
                        sliderImages = listOf(
                            Res.drawable.slider_image1,
                            Res.drawable.slider_image2,
                            Res.drawable.slider_image3
                        ),
                        focusedCardHeight = 300.dp,
                        unFocusedCardHeight = 250.dp
                    )

                    TroopCards(
                        state = troopCardState,
                        modifier = Modifier.padding(horizontal = 10.dp),
                        troops = uiState.troopList,
                        cardWidth = 250.dp,
                        header = stringResource(Res.string.troops),
                        duration = 1000,
                        navigateToDetail = navigateToDetail
                    )

                    TroopCards(
                        state = troopCardState,
                        modifier = Modifier.padding(horizontal = 10.dp),
                        troops = uiState.superTroopList,
                        cardWidth = 250.dp,
                        header = stringResource(Res.string.super_troops),
                        duration = 1000,
                        navigateToDetail = navigateToDetail
                    )
                }

                VerticalScrollbar(
                    modifier = Modifier
                        .fillMaxHeight()
                        .align(Alignment.CenterEnd),
                    adapter = rememberScrollbarAdapter(state),
                    style = ScrollbarStyle(
                        hoverDurationMillis = 1000,
                        minimalHeight = 0.dp,
                        shape = RoundedCornerShape(10.dp),
                        thickness = 8.dp,
                        unhoverColor = Color.White.copy(alpha = 0.2f),
                        hoverColor = Color.White.copy(alpha = 0.8f)
                    )
                )

                HorizontalScrollbar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomStart),
                    adapter = rememberScrollbarAdapter(troopCardState),
                    style = ScrollbarStyle(
                        hoverDurationMillis = 1000,
                        minimalHeight = 0.dp,
                        shape = RoundedCornerShape(10.dp),
                        thickness = 8.dp,
                        unhoverColor = Color.White.copy(alpha = 0.2f),
                        hoverColor = Color.White.copy(alpha = 0.8f)
                    )
                )
            }
        } else {
            Loader(
                fontSize = 18,
                loaderHeight = 15.dp,
                loaderWidth = 150.dp
            )
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen(
        innerPadding = PaddingValues(),
        uiState = UiState(
            troopList = listOf(
                Troop(
                    _id = "1",
                    name = "Giant",
                    description = "These big guys may seem calm, but show a Cannon or Archer Tower and you’ll see their fury unleashed!",
                    color = "0XFFF98B68",
                    image = "",
                    isSuperTroop = false
                )
            )
        ),
        onGameClick = { },
        onAboutClick = { },
        onMenuClick = { },
        navigateToDetail = { }
    )
}