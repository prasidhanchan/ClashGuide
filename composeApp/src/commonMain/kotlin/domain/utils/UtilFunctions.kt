package domain.utils

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import org.koin.compose.currentKoinScope

@Composable
inline fun <reified T: ViewModel> koinViewModel() : T {
    val scope = currentKoinScope()
    return scope.get<T>()
}