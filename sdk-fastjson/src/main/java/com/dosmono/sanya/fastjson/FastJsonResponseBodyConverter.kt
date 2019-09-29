package com.dosmono.sanya.fastjson

import com.alibaba.fastjson.JSON

import java.io.IOException
import java.lang.reflect.Type

import okhttp3.ResponseBody
import okio.BufferedSource
import okio.Okio
import retrofit2.Converter

class FastJsonResponseBodyConverter<T>(private val type: Type?) : Converter<ResponseBody, T> {

    /*
    * 转换方法
    */
    @Throws(IOException::class)
    override fun convert(value: ResponseBody): T? {
        val bufferedSource = Okio.buffer(value.source())
        val tempStr = bufferedSource.readUtf8()
        bufferedSource.close()
        return JSON.parseObject<T>(tempStr, type)

    }
}

