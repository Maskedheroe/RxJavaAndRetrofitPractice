package com.example.fangxy.rxrttest

import com.safframework.http.interceptor.LoggingInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.fastjson.FastJsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitManager {

    companion object {
        private var mRetrofit: Retrofit? = null

        public fun retrofit():Retrofit{
            //配置Retrofit
            if(mRetrofit == null) {
                val bulider: OkHttpClient.Builder = OkHttpClient.Builder()
                bulider.writeTimeout(30 * 1000, TimeUnit.MILLISECONDS)
                bulider.readTimeout(20 * 1000, TimeUnit.MILLISECONDS)
                bulider.connectTimeout(15 * 1000, TimeUnit.MILLISECONDS)
                var loggingInterceptor: LoggingInterceptor =
                        LoggingInterceptor.Builder()
                                .loggable(true)
                                .request()
                                .requestTag("Request")
                                .response()
                                .requestTag("Response")
                                .build()

                bulider.addInterceptor(loggingInterceptor)

                val okHttpClient: OkHttpClient = bulider.build()
                mRetrofit = Retrofit.Builder()
                        .baseUrl()
                        .addConverterFactory(FastJsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .client(okHttpClient)
                        .build()
            }
            return mRetrofit as Retrofit
        }
    }
}