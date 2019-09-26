package com.dosmono.sanya.main.di

import android.app.Application
import com.dosmono.sanya.architecture.app.BaseApp
import dagger.BindsInstance
import dagger.Component
import com.dosmono.sanya.architecture.di.AppModule
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

    fun inject(application: BaseApp)
}