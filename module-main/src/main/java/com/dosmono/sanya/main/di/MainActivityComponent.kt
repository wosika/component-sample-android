package com.dosmono.sanya.main.di

import com.dosmono.sanya.architecture.di.AppComponent
import com.dosmono.sanya.architecture.mvi.di.ActivityScope
import com.dosmono.sanya.main.mvi.MainActivity
import dagger.BindsInstance
import dagger.Component

@ActivityScope
@Component(modules = [MainActivityModule::class], dependencies = [AppComponent::class])
interface MainActivityComponent {


    @Component.Builder
    interface Builder {

        @BindsInstance
        fun activity(mainActivity: MainActivity): Builder


        fun appComponent(appComponent: AppComponent): Builder


        fun build(): MainActivityComponent
    }

    fun inject(mainActivity: MainActivity)
}