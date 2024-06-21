import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import domain.utils.clashBlack
import domain.utils.koinViewModel
import navigation.ClashGuideNavigation
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import presentation.home.HomeViewModel

@Composable
@Preview
fun ClashGuideApp() {
    MaterialTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            backgroundColor = clashBlack
        ) { innerPadding ->
            KoinContext {
                val homeViewModel = koinViewModel<HomeViewModel>()

                ClashGuideNavigation(
                    innerPadding = innerPadding,
                    homeViewModel = homeViewModel
                )
            }
        }
    }
}