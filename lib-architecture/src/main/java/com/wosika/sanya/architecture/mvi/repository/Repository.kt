package com.wosika.sanya.architecture.mvi.repository


import javax.inject.Singleton
import retrofit2.Retrofit


@Singleton
abstract class Repository
constructor() : IRepository {


    lateinit var mRetrofit: Retrofit

    /**
     * 根据传入的 Class 获取对应的 Retrofit service
     *
     * @param serviceClass ApiService class
     * @param <T> ApiService class
     * @return ApiService
    </T> */
    @Synchronized
    @Override
     fun <T> obtainRetrofitService(serviceClass: Class<T>): T {
        return mRetrofit.create(serviceClass)
    }


}
