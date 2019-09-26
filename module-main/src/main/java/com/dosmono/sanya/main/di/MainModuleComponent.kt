package com.dosmono.sanya.main.di

import android.app.Application
import com.dosmono.sanya.architecture.app.App
import com.dosmono.sanya.architecture.di.AppComponent
import com.dosmono.sanya.architecture.mvi.di.ActivityScope
import com.dosmono.sanya.architecture.mvi.view.activity.InjectionActivity
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import com.dosmono.sanya.architecture.di.AppModule
import dagger.Binds
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [AndroidInjectionModule::class, AndroidSupportInjectionModule::class, AppModule::class,ActivityModule::class])
interface MainModuleComponent  {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): MainModuleComponent
    }

    fun inject(application: App)
}