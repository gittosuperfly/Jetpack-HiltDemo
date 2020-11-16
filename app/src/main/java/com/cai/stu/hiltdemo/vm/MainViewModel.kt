package com.cai.stu.hiltdemo.vm

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cai.stu.hiltdemo.data.MainDataSource
import com.cai.stu.hiltdemo.data.model.Weather
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(private val source: MainDataSource) : ViewModel() {

    val weather = MutableLiveData<Weather>()
    val isLoadWeather = MutableLiveData<Boolean>(false)

    fun loadWeather() {
        viewModelScope.launch {
            weather.value = source.getNowWeather(LOCATION, KEY)
            isLoadWeather.value = true
        }
    }

    companion object {
        const val LOCATION = "101010100"
        const val KEY = "4770dcc5782c4a5bb9b1123f69b45364"
    }
}