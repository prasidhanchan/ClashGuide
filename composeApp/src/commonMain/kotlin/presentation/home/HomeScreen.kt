package presentation.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import domain.models.Troop

@Composable
expect fun HomeScreen(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues,
    uiState: UiState,
    onGameClick: () -> Unit,
    onAboutClick: () -> Unit,
    onMenuClick: () -> Unit,
    navigateToDetail: (Troop) -> Unit
)