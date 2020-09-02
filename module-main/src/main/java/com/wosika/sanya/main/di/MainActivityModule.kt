package com.wosika.sanya.main.di


import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.wosika.sanya.architecture.mvi.di.ActivityScope
import com.wosika.sanya.main.mvi.*
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module//(includes = [MainActivityBindModule::class])
class MainActivityModule {

    @Provides
    @ActivityScope
    fun provideViewModel(activity: FragmentActivity, repo: MainRepository): MainViewModel {
        return ViewModelProviders.of(
            activity,
            MainViewModelFactory(repo)
        )[MainViewModel::class.java]
    }


    @Provides
    @ActivityScope
    fun provideMainRemoteDataSource(retrofit: Retrofit): MainRemoteDataSource {
        return MainRemoteDataSource(retrofit)
    }


    @Provides
    @ActivityScope
    fun provideMainLocalDataSource(): MainLocalDataSource {
        return MainLocalDataSource()
    }



    @Provides
    @ActivityScope
    fun provideRepository(
        remoteDataSource: MainRemoteDataSource,
        localDataSource: MainLocalDataSource
    ): MainRepository {
        return MainRepository(localDataSource, remoteDataSource)
    }

}


/*@Module
abstract class MainActivityBindModule {

    @Binds
    internal abstract fun bindMainDataSourceRepository(repositoryManager: MainRepository): MainRepository

}*/
