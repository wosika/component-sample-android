package com.dosmono.sanya.architecture.di

import android.app.Application
import com.dosmono.sanya.architecture.app.WTF
import dagger.Module
import dagger.Provides
import timber.log.Timber
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideWTF(application: Application): WTF {
        return WTF("wosika", "25").apply {
            Timber.d("AppModule提供的wtf$this")
        }
    }

}