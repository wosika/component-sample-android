package com.dosmono.sanya.architecture.di

import android.app.Application
import com.dosmono.sanya.architecture.app.WTF
import com.dosmono.sanya.fastjson.FastJsonConverterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import timber.log.Timber
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideWTF(application: Application): WTF {
        return WTF("wosika", "25").apply {
            Timber.d("AppModule提供的wtf$this")
        }
    }


    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.baidu.com")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(FastJsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }


    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }



}