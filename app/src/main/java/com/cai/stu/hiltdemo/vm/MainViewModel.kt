package com.cai.stu.hiltdemo.vm

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cai.stu.hiltdemo.data.MainRepository
import com.cai.stu.hiltdemo.data.model.Logger
import com.cai.stu.hiltdemo.data.model.Weather
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(private val source: MainRepository) : ViewModel() {

    val weather = MutableLiveData<Weather>()
    val logger = MutableLiveData<List<Logger>>()

    val isLoadWeather = MutableLiveData(false)

    fun loadWeather() {
        viewModelScope.launch {
            weather.value = source.getNowWeather(LOCATION, KEY)
            source.insertLogger("获取数据")
            isLoadWeather.value = true
        }
    }

    fun queryAllLogger() {
        viewModelScope.launch {
            logger.value = source.queryAllLogger()
            Log.d("tag_log", logger.value.toString())
        }
    }

    companion object {
        const val LOCATION = "101010100"
        const val KEY = "4770dcc5782c4a5bb9b1123f69b45364"
    }
}