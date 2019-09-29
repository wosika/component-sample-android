package com.dosmono.sanya.fastjson

import java.lang.reflect.Type

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit

class FastJsonConverterFactory : Converter.Factory() {

    /**
     * 需要重写父类中responseBodyConverter，该方法用来转换服务器返回数据
     */
    override fun responseBodyConverter(
        type: Type?,
        annotations: Array<Annotation>?,
        retrofit: Retrofit?
    ): Converter<ResponseBody, *>? {
        return FastJsonResponseBodyConverter<Any>(type)
    }

    /**
     * 需要重写父类中responseBodyConverter，该方法用来转换发送给服务器的数据
     */
    override fun requestBodyConverter(
        type: Type?,
        parameterAnnotations: Array<Annotation>?,
        methodAnnotations: Array<Annotation>?,
        retrofit: Retrofit?
    ): Converter<*, RequestBody>? {
        return FastJsonRequestBodyConverter<Any>()
    }


    companion object {
        fun create(): FastJsonConverterFactory {
            return FastJsonConverterFactory()
        }
    }
}

