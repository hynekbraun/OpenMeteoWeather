package com.hynekbraun.openmeteoweather.presentation.mainscreen.util

import com.hynekbraun.openmeteoweather.domain.WeatherDataPerHour

sealed class WeatherEvent{
    object FetchData: WeatherEvent()
    data class HourSelected(val selectedHour: WeatherDataPerHour): WeatherEvent()
}
