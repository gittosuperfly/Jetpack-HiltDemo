package com.cai.stu.hiltdemo.data

import com.cai.stu.hiltdemo.data.api.WebService
import com.cai.stu.hiltdemo.data.db.LoggerDao
import com.cai.stu.hiltdemo.data.model.Logger
import javax.inject.Inject


class MainRepository @Inject constructor(
    private val service: WebService,
    private val dao: LoggerDao
) {
    suspend fun getNowWeather(location: String, key: String) = service.getNowWeather(location, key)
    suspend fun insertLogger(message: String) = dao.insert(Logger(message))
    suspend fun queryAllLogger() = dao.queryAll()
}

