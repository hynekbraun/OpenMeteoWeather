package com.hynekbraun.openmeteoweather.presentation.mainscreen.util

data class WeatherState(
    val currentData: CurrentData? = null,
    val dailyForecastData: List<DailyForecastData> = emptyList(),
    val hourlyForecastData: List<WeatherDataPerHour> = emptyList(),
    val error: ViewModelError? = null,
    val isLoading: Boolean = true
)