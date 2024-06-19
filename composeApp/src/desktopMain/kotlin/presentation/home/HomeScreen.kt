package presentation.home

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import clashguide.composeapp.generated.resources.Res
import clashguide.composeapp.generated.resources.slider_image1
import clashguide.composeapp.generated.resources.slider_image2
import clashguide.composeapp.generated.resources.slider_image3
import domain.utils.clashBlack
import presentation.home.components.ClashGuideSlider
import presentation.home.components.HomeAppbar

@Composable
actual fun HomeScreen(
    modifier: Modifier,
    onGameClick: () -> Unit,
    onAboutClick: () -> Unit,
    onMenuClick: () -> Unit
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        backgroundColor = clashBlack
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(all = 20.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HomeAppbar(
                onGameClick = onGameClick,
                onAboutClick = onAboutClick,
                onMenuClick = onMenuClick
            )

            ClashGuideSlider(
                sliderImages = listOf(
                    Res.drawable.slider_image1,
                    Res.drawable.slider_image2,
                    Res.drawable.slider_image3
                )
            )
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen(
        onGameClick = { },
        onAboutClick = { },
        onMenuClick = { }
    )
}