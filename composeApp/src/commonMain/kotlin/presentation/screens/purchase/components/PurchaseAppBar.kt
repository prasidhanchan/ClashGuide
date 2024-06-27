package presentation.screens.purchase.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import clashguide.composeapp.generated.resources.Res
import clashguide.composeapp.generated.resources.purchase_premium
import clashguide.composeapp.generated.resources.purchase_screen_bg
import clashguide.composeapp.generated.resources.verified_tick
import domain.utils.clashBlack
import domain.utils.clashYellow
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import presentation.components.RegularAppBar

/**
 * Custom AppBar composable for Purchase Screen
 * @param modifier The Modifier to be applied to the AppBar
 * @param onBackPress On back press event called when the back button is pressed.
 */
@Composable
fun PurchaseAppBar(
    modifier: Modifier = Modifier,
    verticalPadding: Dp = 0.dp,
    horizontalPadding: Dp = 0.dp,
    onBackPress: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(0.4f),
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            painter = painterResource(resource = Res.drawable.purchase_screen_bg),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            contentDescription = stringResource(resource = Res.string.purchase_premium)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            clashBlack,
                            Color.Transparent
                        )
                    )
                )
        )

        RegularAppBar(
            text = stringResource(resource = Res.string.purchase_premium),
            icon = painterResource(resource = Res.drawable.verified_tick),
            modifier = Modifier.padding(horizontal = horizontalPadding, vertical = verticalPadding),
            iconTint = clashYellow,
            onBackPress = onBackPress
        )
    }
}