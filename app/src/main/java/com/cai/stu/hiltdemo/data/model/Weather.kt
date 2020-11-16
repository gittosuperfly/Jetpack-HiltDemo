package com.cai.stu.hiltdemo.data.model

data class Weather(
    val code: Int,
    val updateTime: String,
    val fxLink: String,
    val now: Now,
    val refer: Refer
) {
    data class Now(
        val obsTime: String,
        val temp: Int,
        val feelsLike: Int,
        val icon: Int,
        val text: String,
        val wind360: Int,
        val windDir: String,
        val windScale: Int,
        val windSpeed: Int,
        val humidity: Int,
        val precip: Double,
        val pressure: Int,
        val vis: Int,
        val cloud: Int,
        val dew: Int
    )

    data class Refer(
        val sources: List<String>,
        val license: List<String>
    )
}