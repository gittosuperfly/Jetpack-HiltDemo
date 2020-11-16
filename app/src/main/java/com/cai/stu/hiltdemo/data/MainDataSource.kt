package com.cai.stu.hiltdemo.data

import com.cai.stu.hiltdemo.data.api.WebService
import javax.inject.Inject


class MainDataSource @Inject constructor(private val service: WebService) {
    suspend fun getNowWeather(location: String, key: String) = service.getNowWeather(location, key)
}

