package com.dosmono.sanya.architecture.di

import android.app.Application
import com.dosmono.sanya.architecture.R
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideAppName(application: Application): String = application.getString(R.string.app_name)


}