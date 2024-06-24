package presentation.screens.about

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun AboutScreen(
    innerPadding: PaddingValues,
    modifier: Modifier = Modifier,
    onBackPress: () -> Unit
)