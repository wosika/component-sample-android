package com.wosika.sanya.main.mvi

import com.wosika.sanya.architecture.mvi.repository.BaseRepositoryBoth

import com.wosika.sanya.architecture.mvi.repository.ILocalDataSource
import com.wosika.sanya.architecture.mvi.repository.IRemoteDataSource
import com.wosika.sanya.main.http.MainService
import io.reactivex.Observable
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