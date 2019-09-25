package com.dosmono.sanya.component.di

import android.app.Application
import com.dosmono.sanya.component.R

import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(subcomponents = [AppSubComponent::class])
class AppModule {

    @Singleton
    @Provides
    fun provideAppName(application: Application): String {
        return application.getString(R.string.app_name)
    }

}