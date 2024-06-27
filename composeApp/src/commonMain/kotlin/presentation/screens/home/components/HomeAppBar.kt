package presentation.screens.home.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * HomeAppBar composable for the Home screen.
 * @param modifier The modifier to be applied on the AppBar.
 * @param onGameClick The on game click callback invoked when the Game button is pressed.
 * @param onAboutClick The on about click callback invoked when the About button is pressed.
 * @param onMenuClick The on game click callback invoked when the Menu button is pressed.
 */
@Composable
expect fun HomeAppBar(
    modifier: Modifier = Modifier,
    onGameClick: () -> Unit,
    onAboutClick: () -> Unit,
    onMenuClick: () -> Unit
)