package com.hynekbraun.openmeteoweather.domain.util

sealed class Resource<S, E>(val data: S? = null, val error: E? = null) {
    class Success<S, Nothing>(data: S) : Resource<S, Nothing>(data)
    class Error<S, E>(error: E, data: S? = null) : Resource<S, E>(error = error, data = data)
}