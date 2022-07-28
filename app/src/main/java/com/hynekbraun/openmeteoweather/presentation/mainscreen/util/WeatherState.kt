package com.hynekbraun.openmeteoweather.presentation.mainscreen.util

import com.hynekbraun.openmeteoweather.domain.WeatherDataPerHour

data class WeatherState(
    val currentData: CurrentData? = null,
    val dailyForecastData: List<DailyForecastData> = emptyList(),
    val hourlyForecastData: List<WeatherDataPerHour> = emptyList(),
    val isLoading: Boolean = true
)