package com.dosmono.sanya.main.mvi

import com.dosmono.sanya.architecture.mvi.repository.BaseRepositoryBoth

import com.dosmono.sanya.architecture.mvi.repository.ILocalDataSource
import com.dosmono.sanya.architecture.mvi.repository.IRemoteDataSource
import retrofit2.Retrofit


class MainRepository(
    mainLocalDataSource: MainLocalDataSource,
    mainRemoteDataSource: MainRemoteDataSource
) : BaseRepositoryBoth<MainRemoteDataSource, MainLocalDataSource>(
    mainRemoteDataSource,
    mainLocalDataSource
) {


}

class MainRemoteDataSource(retrofit: Retrofit) : IRemoteDataSource {


}

class MainLocalDataSource : ILocalDataSource {

}