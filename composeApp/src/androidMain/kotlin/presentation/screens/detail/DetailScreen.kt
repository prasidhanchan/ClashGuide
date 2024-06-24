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
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import domain.utils.LondrinaSolid
import domain.utils.clashBlack
import domain.utils.clashFontColor
import presentation.components.AnimatedText
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

            AsyncImage(
                model = image,
                modifier = Modifier
                    .padding(vertical = 120.dp)
                    .scale(1.8f),
                contentScale = ContentScale.FillBounds,
                filterQuality = FilterQuality.High,
                contentDescription = name
            )

            Text(
                text = description,
                style = TextStyle(
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = LondrinaSolid(),
                    color = clashFontColor
                )
            )
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