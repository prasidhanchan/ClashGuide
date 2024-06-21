import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import clashguide.composeapp.generated.resources.Res
import clashguide.composeapp.generated.resources.app_name
import di.KoinInitializer
import org.jetbrains.compose.resources.stringResource

fun main() = application {
    KoinInitializer().initKoin()

    Window(
        onCloseRequest = ::exitApplication,
        title = stringResource(Res.string.app_name)
    ) {
        ClashGuideApp()
    }
}