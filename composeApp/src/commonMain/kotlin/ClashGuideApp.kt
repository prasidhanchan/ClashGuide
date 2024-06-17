import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import domain.utils.koinViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import presentation.home.HomeScreen
import presentation.home.HomeViewModel

@Composable
@Preview
fun ClashGuideApp() {
    MaterialTheme {
        KoinContext {
            val homeViewModel = koinViewModel<HomeViewModel>()
            val uiState by homeViewModel.uiState.collectAsState()

            HomeScreen()
        }
    }
}