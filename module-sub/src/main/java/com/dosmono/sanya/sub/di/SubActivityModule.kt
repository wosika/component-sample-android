package com.dosmono.sanya.sub.di


import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.dosmono.sanya.architecture.mvi.di.ActivityScope
import com.dosmono.sanya.sub.mvi.SubViewModel
import dagger.Module
import dagger.Provides

@Module
class SubActivityModule {

    @Provides
    @ActivityScope
    fun provideViewModel(activity: FragmentActivity): SubViewModel {
        return ViewModelProviders.of(activity)[SubViewModel::class.java]
    }


}