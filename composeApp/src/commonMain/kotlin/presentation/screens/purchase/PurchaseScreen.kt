package presentation.screens.purchase

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun PurchaseScreen(
    innerPadding: PaddingValues,
    modifier: Modifier = Modifier,
    loading: Boolean,
    hasPurchasedPremium: Boolean,
    onPurchasePress: (Boolean) -> Unit,
    onBackPress: () -> Unit
)