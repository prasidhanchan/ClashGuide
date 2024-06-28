import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import clashguide.composeapp.generated.resources.Res
import clashguide.composeapp.generated.resources.app_name
import clashguide.composeapp.generated.resources.clash_guide_icon
import di.KoinInitializer
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

fun main() = application {
    KoinInitializer().initKoin()
    val state = rememberWindowState(
        position = WindowPosition(Alignment.Center),
        size = DpSize(width = 800.dp, height = 700.dp)
    )

    Window(
        onCloseRequest = ::exitApplication,
        state = state,
        title = stringResource(resource = Res.string.app_name),
        icon = painterResource(resource = Res.drawable.clash_guide_icon)
    ) {
        ClashGuideApp()
    }
}