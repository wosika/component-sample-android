package com.dosmono.sanya.main.di

import com.dosmono.sanya.architecture.mvi.di.ActivityScope
import com.dosmono.sanya.main.mvi.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    internal abstract fun contributesMainActivity(): MainActivity

}