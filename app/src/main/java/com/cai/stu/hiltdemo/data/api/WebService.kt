package com.cai.stu.hiltdemo.data.api

import com.cai.stu.hiltdemo.data.model.Weather
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("/v7/weather/now")
    suspend fun getNowWeather(
        @Query("location") location: String,
        @Query("key") key: String
    ): Weather
}
