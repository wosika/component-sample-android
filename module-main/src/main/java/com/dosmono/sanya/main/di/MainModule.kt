package com.dosmono.sanya.main.di

import androidx.lifecycle.ViewModelProviders
import com.dosmono.sanya.architecture.mvi.di.ActivityScope
import com.dosmono.sanya.component.di.AppSubComponent
import com.dosmono.sanya.main.mvi.MainActivity
import com.dosmono.sanya.main.mvi.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module(subcomponents = [AppSubComponent::class])
abstract class MainModule {



    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    internal abstract fun contributesMainActivity(): MainActivity

}