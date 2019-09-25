package com.dosmono.sanya.main.di

import androidx.lifecycle.ViewModelProviders
import com.dosmono.sanya.architecture.mvi.di.ActivityScope
import com.dosmono.sanya.main.mvi.MainActivity
import com.dosmono.sanya.main.mvi.MainViewModel
import dagger.Module
import dagger.Provides
@Module
class MainActivityModule {

    @ActivityScope
    @Provides
    fun providesViewModel(
        activity: MainActivity
    ): MainViewModel {
        return ViewModelProviders
            .of(activity)[MainViewModel::class.java]
    }


}