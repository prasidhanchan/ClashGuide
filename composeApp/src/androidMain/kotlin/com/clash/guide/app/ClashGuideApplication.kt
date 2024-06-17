package com.clash.guide.app

import android.app.Application
import di.KoinInitializer

class ClashGuideApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        KoinInitializer(applicationContext).initKoin()
    }
}