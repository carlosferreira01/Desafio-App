package com.data.shared.api

import com.data.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {
    private var retrofit: Retrofit

    init {
        retrofit = createRetrofit()
    }

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BaseUrl.getUrl(BuildType.getEnvironmentBuildType()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(createHttpClient())
            .build()
    }

    private fun createHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.readTimeout(2, TimeUnit.MINUTES)
        httpClient.writeTimeout(2, TimeUnit.MINUTES)
        httpClient.connectTimeout(2, TimeUnit.MINUTES)

        httpClient.addInterceptor(createLogInterceptor())

        return httpClient.build()
    }

    private fun createLogInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level =
            when(BuildConfig.DEBUG) {
                true -> HttpLoggingInterceptor.Level.BODY
                false -> HttpLoggingInterceptor.Level.NONE
            }
        return interceptor
    }

    fun <T> createService(service: Class<T>): T {
        return retrofit.create(service)
    }

}