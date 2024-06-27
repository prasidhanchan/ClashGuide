package presentation.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import domain.utils.LondrinaSolid
import domain.utils.clashBlue
import domain.utils.clashFontColor

/**
 * Clash Guide Button composable  with the text.
 * @param text The text to be displayed in the button.
 * @param modifier The Modifier to be applied to the button.
 * @param cornerRadius The corner radius to be applied to the button.
 * @param color The color of the button.
 * @param onHoverColor The color of the button when hovered. By default the this color would be lighter version of the button color.
 * @param fontColor Tye color of the font.
 * @param onClick The on click callback triggered when the button is pressed.
 */
@Composable
fun ClashGuideButton(
    text: String,
    modifier: Modifier = Modifier,
    loading: Boolean,
    cornerRadius: Dp = 20.dp,
    color: Color = clashBlue,
    onHoverColor: Color = color.copy(alpha = 0.4f),
    fontColor: Color = clashFontColor,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    val animatedColor by animateColorAsState(
        targetValue = if (isHovered || loading) onHoverColor else color,
        animationSpec = tween(durationMillis = 800),
        label = "animatedColor"
    )

    Surface(
        modifier = modifier
            .fillMaxWidth(0.9f)
            .height(55.dp)
            .clickable(
                enabled = !loading,
                indication = LocalIndication.current,
                interactionSource = interactionSource,
                onClick = onClick,
            ),
        shape = RoundedCornerShape(cornerRadius),
        color = animatedColor
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            if (!loading) {
                Text(
                    text = text,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = LondrinaSolid(),
                        color = fontColor
                    )
                )
            } else {
                CircularProgressIndicator(
                    modifier = Modifier.size(35.dp),
                    color = Color.White,
                    strokeWidth = 4.dp,
                    strokeCap = StrokeCap.Round
                )
            }
        }
    }
}