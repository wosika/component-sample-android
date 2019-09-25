package com.dosmono.sanya.component.di

import android.app.Application
import com.dosmono.sanya.component.base.App
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent
import dagger.android.AndroidInjector
import javax.inject.Singleton


@Component
interface AppComponent{


    @Subcomponent.Factory
    interface Factory {
        /**
         * Creates an [AndroidInjector] for `instance`. This should be the same instance
         * that will be passed to [.inject].
         */
        fun create(@BindsInstance instance: Application): AppSubComponent
    }

    fun inject(app: App)


}