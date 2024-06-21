package presentation.home.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun HomeAppBar(
    modifier: Modifier = Modifier,
    onGameClick: () -> Unit,
    onAboutClick: () -> Unit,
    onMenuClick: () -> Unit
)