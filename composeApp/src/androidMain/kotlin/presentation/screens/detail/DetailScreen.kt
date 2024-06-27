package presentation.screens.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import domain.utils.clashBlack
import presentation.components.AnimatedText
import presentation.screens.detail.components.AnimatedDescription
import presentation.screens.detail.components.AnimatedImage
import presentation.screens.detail.components.DetailAppBar

@Composable
actual fun DetailScreen(
    innerPadding: PaddingValues,
    modifier: Modifier,
    name: String,
    description: String,
    image: String,
    onBackPress: () -> Unit
) {
    val state = rememberScrollState()

    Surface(
        modifier = modifier.fillMaxSize(),
        color = clashBlack
    ) {
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(all = 30.dp)
                .fillMaxSize()
                .verticalScroll(state),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DetailAppBar(
                modifier = Modifier.padding(bottom = 20.dp),
                onBackPress = onBackPress
            )

            AnimatedText(
                text = name,
                modifier = Modifier.height(70.dp)
            )

            AnimatedImage(
                name = name,
                image = image,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 120.dp)
                    .scale(1.8f)
            )

            AnimatedDescription(description = description)
        }
    }
}

@Preview
@Composable
private fun DetailScreenPreview() {
    DetailScreen(
        innerPadding = PaddingValues(),
        name = "Giant",
        description = "These big guys may seem calm, but show a Cannon or Archer Tower and you’ll see their fury unleashed!",
        image = "",
        onBackPress = { }
    )
}