package di

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class KoinInitializer(
    private val context: Context
) {
    actual fun initKoin() {
        startKoin {
            androidContext(context)
            modules(appModule)
        }
    }
}