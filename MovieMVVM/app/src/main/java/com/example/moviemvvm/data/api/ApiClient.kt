package com.example.moviemvvm.data.api

import com.example.moviemvvm.BuildConfig
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {

    fun getClient(): ApiInterface {
        // 1. Interceptor 객체 생성
        val requestInterceptor: Interceptor = Interceptor { chain ->
            // a. Url 객체 생성 (QueryParameter 추가 가능)
            val url: HttpUrl = chain.request()
                .url()
                .newBuilder()
                .addQueryParameter("api_key", BuildConfig.MOVIE_API_KEY)
                .build()

            // b. Request 객체 생성 (Header 추가 가능)
            val request: Request = chain.request()
                .newBuilder()
                .url(url)
                .build()

            return@Interceptor chain.proceed(request)
        }

        // 2. OkHTTP 클라이언트에서 Interceptor 추가
        val okHttpClient: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .connectTimeout(60, TimeUnit.SECONDS)  // 연결 시간 제한 60초
            .build()

        // 3. 인터페이스 구현체 반환
        return Retrofit.Builder()
            .client(OkHttpClient())
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }

    companion object {
        private const val BASE_URL = "https://api.themoviedb.org/3/"
        private const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/342"
    }
}