package com.dosmono.sanya.main.mvi

import com.dosmono.sanya.architecture.mvi.repository.BaseRepositoryBoth
import com.dosmono.sanya.architecture.mvi.repository.BaseRepositoryNothing
import com.dosmono.sanya.architecture.mvi.repository.ILocalDataSource
import com.dosmono.sanya.architecture.mvi.repository.IRemoteDataSource


class MainRepository(
    mainLocalDataSource: MainLocalDataSource,
    mainRemoteDataSource: MainRemoteDataSource
) : BaseRepositoryBoth<MainRemoteDataSource, MainLocalDataSource>(
    mainRemoteDataSource,
    mainLocalDataSource
) {


}

class MainRemoteDataSource : IRemoteDataSource {

}

class MainLocalDataSource : ILocalDataSource {

}