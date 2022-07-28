package com.hynekbraun.openmeteoweather.presentation.mainscreen.util

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.hynekbraun.openmeteoweather.R

sealed class ToastEventHandler(@StringRes val errorId: Int) {

    data class NetworkToastEvent(@StringRes val messageId: Int = R.string.network_error) :
        ToastEventHandler(errorId = messageId)

    data class GpsEvent(@StringRes val messageId: Int = R.string.gps_error) :
        ToastEventHandler(messageId)

    data class GenericToastEvent(@StringRes val messageId: Int = R.string.generic_error) :
        ToastEventHandler(messageId)

    data class PermissionEvent(@StringRes val messageId: Int = R.string.permission_error) :
        ToastEventHandler(messageId)

    @Composable
    fun asString(): String {
        return stringResource(errorId)
    }

    fun asString(context: Context): String {
        return context.getString(errorId)
    }
}


