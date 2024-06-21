package domain.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import org.koin.compose.currentKoinScope

/**
 * Function to get view model from Koin.
 * @return Returns view model of type T.
 */
@Composable
inline fun <reified T : ViewModel> koinViewModel(): T {
    val scope = currentKoinScope()
    return scope.get<T>()
}

fun String.toColor(): Long {
    return this.toLong()
}