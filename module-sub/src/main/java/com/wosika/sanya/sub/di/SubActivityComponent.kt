package com.wosika.sanya.sub.di

import androidx.fragment.app.FragmentActivity
import com.wosika.sanya.architecture.di.AppComponent
import com.wosika.sanya.architecture.mvi.di.ActivityScope
import com.wosika.sanya.sub.mvi.SubActivity
import dagger.BindsInstance
import dagger.Component

@ActivityScope
@Component(modules = [SubActivityModule::class], dependencies = [AppComponent::class])
interface SubActivityComponent {


    @Component.Builder
    interface Builder {

        @BindsInstance
        fun activity(activity: FragmentActivity): Builder


        fun appComponent(appComponent: AppComponent): Builder


        fun build(): SubActivityComponent
    }

    fun inject(activity: SubActivity)
}