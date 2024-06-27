package presentation.screens.detail.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import domain.models.Troop
import kotlinx.coroutines.delay

/**
 * Animated Image to display animated image of a [Troop].
 * @param name The name of the troop.
 * @param image The string uri of the troop.
 * @param modifier The Modifier to be applied on the composable.
 */
@Composable
fun AnimatedImage(
    name: String,
    image: String,
    modifier: Modifier = Modifier
) {
    var visible by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = Unit) {
        delay(1000L)
        visible = true
    }

    AnimatedVisibility(
        visible = visible,
        enter = slideInHorizontally(
            initialOffsetX = { it },
            animationSpec = tween(durationMillis = 800)
        )
    ) {
        AsyncImage(
            model = image,
            modifier = modifier,
            contentScale = ContentScale.Fit,
            filterQuality = FilterQuality.High,
            contentDescription = name
        )
    }
}