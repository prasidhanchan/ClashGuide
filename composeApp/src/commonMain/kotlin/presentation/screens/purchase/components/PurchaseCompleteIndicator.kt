package presentation.screens.purchase.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import clashguide.composeapp.generated.resources.Res
import clashguide.composeapp.generated.resources.purchase_complete
import clashguide.composeapp.generated.resources.tick
import domain.utils.LondrinaSolid
import domain.utils.clashBlack
import domain.utils.clashFontColor
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

/**
 * Purchase Complete Indicator to display purchase complete message on after purchase.
 * @param visible The visibility boolean required to display the composable.
 * @param modifier The Modifier to be applied to the composable.
 * @param onDismiss on dismiss callback to be triggered when the indicator is dismissed.
 */
@Composable
fun PurchaseCompleteIndicator(
    visible: Boolean,
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    LaunchedEffect(key1 = visible) {
        if (visible) {
            delay(2000L)
            onDismiss()
        }
    }

    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(
            animationSpec = tween(durationMillis = 800)
        ),
        exit = fadeOut(
            animationSpec = tween(durationMillis = 800)
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = clashBlack.copy(alpha = 0.8f))
                .clickable(
                    indication = null,
                    interactionSource = interactionSource,
                    onClick = onDismiss
                ),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = modifier.size(200.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(resource = Res.drawable.tick),
                    modifier = Modifier.size(100.dp),
                    tint = Color.Green,
                    contentDescription = stringResource(resource = Res.string.purchase_complete)
                )

                Text(
                    text = stringResource(resource = Res.string.purchase_complete),
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = LondrinaSolid(),
                        color = clashFontColor
                    )
                )
            }
        }
    }
}