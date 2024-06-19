package di

import org.koin.core.context.startKoin

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class KoinInitializer {
    actual fun initKoin() {
        startKoin {
            modules(appModule)
        }
    }
}