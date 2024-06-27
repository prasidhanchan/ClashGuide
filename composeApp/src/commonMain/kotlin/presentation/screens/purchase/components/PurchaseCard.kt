package presentation.screens.purchase.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Purchase Card composable for purchase screen to display the purchase benefits.
 * @param modifier The Modifier to be applied to the Card.
 * @param loading Loading boolean to display circular progress indicator. (Used only for Desktop).
 * @param onPurchasePress On purchase callback triggered when the purchase button is pressed (Used only for Desktop).
 */
@Composable
expect fun PurchaseCard(
    modifier: Modifier = Modifier,
    loading: Boolean = false,
    onPurchasePress: () -> Unit = { }
)