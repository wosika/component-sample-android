package com.dosmono.sanya.main.di

import androidx.lifecycle.ViewModelProviders
import com.dosmono.sanya.architecture.app.WTF
import com.dosmono.sanya.architecture.mvi.di.ActivityScope
import com.dosmono.sanya.main.Person
import com.dosmono.sanya.main.mvi.MainActivity
import com.dosmono.sanya.main.mvi.MainViewModel
import dagger.Module
import dagger.Provides
import timber.log.Timber
import javax.inject.Singleton

@Module
class MainActivityModule {


    @Provides
    fun providesViewModel(
        activity: MainActivity
    ): MainViewModel {
        return ViewModelProviders
            .of(activity)[MainViewModel::class.java]
    }



    @Provides
    fun providesPerson(
        wtf: WTF
    ): Person {
        Timber.d("传进来的wtf的对象值是多少" + wtf.toString())
        return Person(wtf)
    }
}