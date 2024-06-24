package presentation.screens.detail

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
    Surface(
        modifier = modifier.fillMaxSize(),
        color = clashBlack
    ) {
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 30.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            DetailAppBar(
                modifier = Modifier.padding(top = 20.dp),
                iconSize = 100.dp,
                verticalAlignment = Alignment.Top,
                onBackPress = onBackPress
            )

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.CenterEnd
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.Start
                ) {
                    AnimatedText(
                        text = name,
                        modifier = Modifier.height(150.dp),
                        fonSize = 120
                    )

                    Text(
                        text = description,
                        modifier = Modifier.fillMaxWidth(0.4f),
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = LondrinaSolid(),
                            color = clashFontColor
                        ),
                        textAlign = TextAlign.Start
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(0.6f)
                        .padding(bottom = 30.dp, top = 30.dp, end = 80.dp),
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImage(
                        model = image,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillBounds,
                        filterQuality = FilterQuality.High,
                        contentDescription = name
                    )
                }
            }
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