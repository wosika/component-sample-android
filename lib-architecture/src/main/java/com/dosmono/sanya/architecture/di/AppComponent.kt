package com.dosmono.sanya.architecture.di

import android.app.Application
import com.dosmono.sanya.architecture.app.BaseApp
import com.dosmono.sanya.architecture.app.WTF
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, AndroidSupportInjectionModule::class, AppModule::class])
interface AppComponent : AndroidInjector<BaseApp> {

    @Component.Factory
    interface Factory {
        /**
         * Creates an [AndroidInjector] for `instance`. This should be the same instance
         * that will be passed to [.inject].
         */
        fun create(@BindsInstance application: Application): AppComponent
    }


    fun wtf(): WTF

}