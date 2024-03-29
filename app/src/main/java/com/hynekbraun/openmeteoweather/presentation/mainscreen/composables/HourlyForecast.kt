package com.hynekbraun.openmeteoweather.presentation.mainscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.hynekbraun.openmeteoweather.R
import com.hynekbraun.openmeteoweather.domain.WeatherDataPerHour
import com.hynekbraun.openmeteoweather.ui.theme.darkBackGround
import com.hynekbraun.openmeteoweather.ui.theme.lightBackGround
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt

@Composable
fun HourlyForecast(
    weatherData: WeatherDataPerHour,
    modifier: Modifier = Modifier,
    textColor: Color = Color.White,
    isSelected: Boolean = false
) {
    val formattedTime = remember(weatherData) {
        weatherData.time.format(
            DateTimeFormatter.ofPattern("HH:mm")
        )
    }
    Column(
        modifier = modifier
            .height(100.dp)
            .background(
                shape = RoundedCornerShape(10.dp),
                color = if (isSelected) darkBackGround else lightBackGround
            ).padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = formattedTime,
            color = Color.LightGray
        )
        Image(
            painter = painterResource(id = weatherData.weatherType.iconRes),
            contentDescription = null,
            modifier = Modifier.width(40.dp)
        )
        Text(
            text = stringResource(
                id = R.string.weather_temperature,
                weatherData.temperature.roundToInt()
            ),
            color = textColor,
            fontWeight = FontWeight.Bold
        )
    }
}
