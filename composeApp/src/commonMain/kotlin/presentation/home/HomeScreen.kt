package presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun HomeScreen(
    modifier: Modifier = Modifier,
    onGameClick: () -> Unit,
    onAboutClick: () -> Unit,
    onMenuClick: () -> Unit
)