package com.example.moviemvvm.data.api

import com.example.moviemvvm.data.value.MovieDetails
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    // Single : RxJava 의 observable 타입 중 하나
    // RxJava two key components : observer & observable
    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") movie_id: String): Single<MovieDetails>
}