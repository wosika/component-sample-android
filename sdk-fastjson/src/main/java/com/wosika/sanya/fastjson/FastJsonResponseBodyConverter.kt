package com.wosika.sanya.fastjson

import com.alibaba.fastjson.JSON

import java.io.IOException
import java.lang.reflect.Type

import okhttp3.ResponseBody
import retrofit2.Converter


class FastJsonResponseBodyConverter<T>(private val type: Type) : Converter<ResponseBody, T> {
    @Throws(IOException::class)
    override fun convert(value: ResponseBody): T? {
        return JSON.parseObject<T>(value.string(), type)
    }
}
