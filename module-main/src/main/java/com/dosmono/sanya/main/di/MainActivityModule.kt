package com.dosmono.sanya.main.di


import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.dosmono.sanya.architecture.app.WTF
import com.dosmono.sanya.architecture.mvi.di.ActivityScope
import com.dosmono.sanya.main.Person
import com.dosmono.sanya.main.mvi.MainViewModel
import dagger.Module
import dagger.Provides
import timber.log.Timber

@Module
class MainActivityModule {

    @Provides
    @ActivityScope
    fun provideMainViewModel(activity: FragmentActivity): MainViewModel {
        return ViewModelProviders.of(activity)[MainViewModel::class.java]
    }


    @Provides
    @ActivityScope
    fun provideString(wtf: WTF): Person {
        Timber.d("提供person时注入的wtf是$wtf")

        return Person(wtf)
    }
}