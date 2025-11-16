package com.jn.weatherapp.ui.home

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class WeatherResponseModel(

    @SerialName("hourly_units")
    val hourlyUnits: HourlyUnits? = null,

    @SerialName("latitude")
    val latitude: String? = null,

    @SerialName("hourly")
    val hourly: Hourly? = null,

    @SerialName("longitude")
    val longitude: String? = null
)

@Serializable
data class HourlyUnits(

    @SerialName("temperature_2m")
    val temperature2m: String? = null,

    @SerialName("time")
    val time: String? = null
)

@Serializable
data class Hourly(

    @SerialName("temperature_2m")
    val temperature2m: List<String?>? = null,

    @SerialName("time")
    val time: List<String?>? = null
)
