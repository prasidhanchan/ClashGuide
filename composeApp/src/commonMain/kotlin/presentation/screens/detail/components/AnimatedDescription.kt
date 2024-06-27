package presentation.screens.detail.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import domain.models.Troop
import domain.utils.LondrinaSolid
import domain.utils.clashFontColor
import kotlinx.coroutines.delay

/**
 * Animated Description to display details about a [Troop].
 * @param description The description of the troop.
 * @param modifier The Modifier to be applied on the composable.
 * @param fonSize The font size of the text.
 */
@Composable
fun AnimatedDescription(
    description: String,
    modifier: Modifier = Modifier,
    fonSize: Int = 24
) {
    var visible by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = Unit) {
        delay(1000L)
        visible = true
    }

    AnimatedVisibility(
        visible = visible,
        enter = slideInVertically(
            initialOffsetY = { it },
            animationSpec = tween(
                durationMillis = 800,
                delayMillis = 500
            )
        )
    ) {
        Text(
            text = description,
            modifier = modifier,
            style = TextStyle(
                fontSize = fonSize.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = LondrinaSolid(),
                color = clashFontColor
            )
        )
    }
}