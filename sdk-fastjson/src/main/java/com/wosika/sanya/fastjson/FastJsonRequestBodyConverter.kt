package com.wosika.sanya.fastjson

import com.alibaba.fastjson.serializer.SerializeConfig

import com.alibaba.fastjson.JSON

import java.io.IOException

import okhttp3.MediaType
import okhttp3.RequestBody

import retrofit2.Converter

class FastJsonRequestBodyConverter<T>(private val serializeConfig: SerializeConfig) :
    Converter<T, RequestBody> {

    @Throws(IOException::class)
    override fun convert(value: T): RequestBody {
        return RequestBody.create(MEDIA_TYPE, JSON.toJSONBytes(value, serializeConfig))
    }

    companion object {
        private val MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8")
    }
}