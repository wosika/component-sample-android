package com.dosmono.sanya.main.mvi

import com.dosmono.sanya.architecture.mvi.repository.BaseRepositoryBoth

import com.dosmono.sanya.architecture.mvi.repository.ILocalDataSource
import com.dosmono.sanya.architecture.mvi.repository.IRemoteDataSource
import com.dosmono.sanya.main.http.MainService
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit


class MainRepository(
    mainLocalDataSource: MainLocalDataSource,
    mainRemoteDataSource: MainRemoteDataSource
) : BaseRepositoryBoth<MainRemoteDataSource, MainLocalDataSource>(
    mainRemoteDataSource,
    mainLocalDataSource
) {


}

class MainRemoteDataSource(private val retrofit: Retrofit) : IRemoteDataSource {

    fun getNumberFrom(phone: String): Observable<MainViewState> {
        return retrofit.create(MainService::class.java)
            .getPhoneNumberFrom(phone)
            .subscribeOn(Schedulers.io())
            .map<MainViewState> { MainViewState.CheckSuccessState(it) }
            .onErrorReturn { MainViewState.ErrorState(it) }
    }

}

class MainLocalDataSource : ILocalDataSource {

}