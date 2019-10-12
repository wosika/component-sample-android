package com.dosmono.sanya.main.http

import io.reactivex.Observable
import retrofit2.http.GET

interface MainService {

    @GET("https://api.jisuapi.com/shouji/query?appkey=e6e427982196332c")
    fun  getPhoneNumberFrom(number:String):Observable<String>
}