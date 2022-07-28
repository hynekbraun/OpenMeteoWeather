package com.hynekbraun.openmeteoweather.presentation.mainscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hynekbraun.openmeteoweather.R
import com.hynekbraun.openmeteoweather.presentation.mainscreen.util.CurrentData
import com.hynekbraun.openmeteoweather.ui.theme.darkBackGround
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt

@Composable
fun WeatherCard(
    modifier: Modifier = Modifier,
    weatherData: CurrentData?
) {
    weatherData?.weatherData?.let { dataPerHour ->
        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            backgroundColor = darkBackGround,
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = weatherData.weatherData.time
                        .format(DateTimeFormatter.ofPattern("EEE, MMM d, HH:mm")),
                    modifier = Modifier.align(Alignment.End),
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = painterResource(id = weatherData.weatherData.weatherType.iconRes),
                    contentDescription = stringResource(R.string.content_desc_weather_icon),
                    modifier = Modifier.width(200.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(
                        id = R.string.weather_temperature,
                        weatherData.weatherData.temperature.roundToInt()
                    ),
                    fontSize = 50.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = weatherData.weatherData.weatherType.weatherDesc,
                    fontSize = 20.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    WeatherItem(
                        value = dataPerHour.pressure.roundToInt(),
                        description = stringResource(R.string.unit_hectopascal),
                        icon = ImageVector.vectorResource(id = R.drawable.ic_pressure),
                    )
                    WeatherItem(
                        value = dataPerHour.humidity.roundToInt(),
                        description = stringResource(R.string.unit_percentage),
                        icon = ImageVector.vectorResource(id = R.drawable.ic_drop),
                    )
                    WeatherItem(
                        value = dataPerHour.windSpeed.roundToInt(),
                        description = stringResource(R.string.unit_kilometres_per_hour),
                        icon = ImageVector.vectorResource(id = R.drawable.ic_wind),
                    )
                }
            }
        }
    }
}