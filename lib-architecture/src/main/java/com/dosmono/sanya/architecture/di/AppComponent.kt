package com.dosmono.sanya.architecture.di

import android.app.Application
import com.dosmono.sanya.architecture.app.BaseApp
import com.dosmono.sanya.architecture.app.WTF
import dagger.BindsInstance
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }

    fun inject(baseApp: BaseApp)


    fun wtf(): WTF

    //提供retrofit
    fun retrofit():Retrofit

}