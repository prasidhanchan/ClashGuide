package di

import org.koin.core.context.startKoin

actual class KoinInitializer {
    actual fun initKoin() {
        startKoin {
            modules(appModule)
        }
    }
}