import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import di.KoinInitializer

fun main() = application {
    KoinInitializer().initKoin()

    Window(
        onCloseRequest = ::exitApplication,
        title = "Clash Guide",
    ) {
        ClashGuideApp()
    }
}