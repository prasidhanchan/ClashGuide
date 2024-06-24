package presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import domain.utils.LondrinaSolid
import domain.utils.clashFontColor
import kotlinx.coroutines.delay

/**
 * Animated text composable to vertically animate text.
 * @param text The Text to be animated.
 * @param modifier The Modifier to be applied on the text row.
 * @param fonSize Font size to be displayed.
 */
@Composable
fun AnimatedText(
    text: String,
    modifier: Modifier = Modifier,
    fonSize: Int = 55
) {
    val splitText = text.split("")

    var visible by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = Unit) {
        delay(600L)
        visible = true
    }

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        splitText.forEachIndexed { index, _ ->
            AnimatedVisibility(
                visible = visible,
                enter = slideInVertically(
                    initialOffsetY = { it },
                    animationSpec = tween(
                        durationMillis = 500,
                        delayMillis = index * 100
                    )
                )
            ) {
                Text(
                    text = splitText[index],
                    style = TextStyle(
                        fontSize = fonSize.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = LondrinaSolid(),
                        color = clashFontColor
                    ),
                    textAlign = TextAlign.Start,
                    maxLines = 2,
                    overflow = TextOverflow.Clip
                )
            }
        }
    }
}