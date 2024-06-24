package presentation.screens.game

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun GameScreen(
    innerPadding: PaddingValues,
    modifier: Modifier = Modifier,
    onBackPress: () -> Unit
)