package com.crisiscore.www.weatherapp.repository

import com.crisiscore.www.weatherapp.net.models.currentweather.CurrentWeatherData
import com.crisiscore.www.weatherapp.net.models.fivedaysforecast.FiveDaysWeatherData
import io.reactivex.Observable

/**
 * Created by Aliaksandr Kotau on 05.11.2017.
 */
interface Repository {

    fun getCurrentWeather(cityName: String): Observable<CurrentWeatherData>

    fun getFiveDaysForecastWeatherData(cityName: String): Observable<FiveDaysWeatherData>
}