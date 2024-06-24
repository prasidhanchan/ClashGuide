package presentation.screens.detail

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun DetailScreen(
    innerPadding: PaddingValues,
    modifier: Modifier = Modifier,
    name: String,
    description: String,
    image: String,
    onBackPress: () -> Unit
)