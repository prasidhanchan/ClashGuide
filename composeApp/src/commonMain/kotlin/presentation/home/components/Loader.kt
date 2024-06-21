package presentation.home.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import clashguide.composeapp.generated.resources.Res
import clashguide.composeapp.generated.resources.loading
import domain.utils.ClashMagic
import domain.utils.clashBlack
import domain.utils.clashFontColor
import domain.utils.clashOffBlack
import domain.utils.clashPink
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.stringResource

/**
 * Loader composable to display a loading animation.
 * @param modifier The Modifier to be applied to the loader.
 * @param fontSize The font size of the Loading text.
 * @param loaderHeight Height of the loading bar.
 * @param loaderWidth Width of the loading bar.
 */
@Composable
fun Loader(
    modifier: Modifier = Modifier,
    fontSize: Int = 20,
    loaderHeight: Dp = 20.dp,
    loaderWidth: Dp = 200.dp
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = clashBlack.copy(alpha = 0.4f)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = stringResource(Res.string.loading),
            style = TextStyle(
                fontSize = fontSize.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = ClashMagic(),
                color = clashFontColor,
                shadow = Shadow(
                    color = clashBlack,
                    blurRadius = 18f
                )
            )
        )

        LoadingBar(
            modifier = Modifier
                .height(loaderHeight)
                .width(loaderWidth)
        )
    }
}

/**
 * Loading Bar with animated loading progress.
 * @param modifier The Modifier to applied to the loading bar.
 */
@Composable
fun LoadingBar(modifier: Modifier = Modifier) {
    var width by remember { mutableFloatStateOf(0f) }
    val animatedWidth by animateFloatAsState(
        targetValue = width,
        animationSpec = tween(durationMillis = 800),
        label = "loaderAnimation"
    )

    LaunchedEffect(Unit) {
        width = 0.4f
        delay(600L)
        width = 0.8f
        delay(400L)
        width = 1f
    }

    Box(
        modifier = modifier
            .width(200.dp)
            .height(20.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(color = clashOffBlack)
            .shadow(
                elevation = 15.dp,
                shape = RoundedCornerShape(5.dp)
            ),
        contentAlignment = Alignment.CenterStart
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(animatedWidth)
                .clip(RoundedCornerShape(5.dp))
                .background(color = clashPink)
        )
    }
}