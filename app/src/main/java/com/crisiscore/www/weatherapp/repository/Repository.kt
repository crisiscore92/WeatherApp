package com.crisiscore.www.weatherapp.repository

import com.crisiscore.www.weatherapp.net.models.currentweathermodels.CurrentWeatherData
import com.crisiscore.www.weatherapp.net.models.fivedaysforecastmodels.FiveDaysWeatherData
import com.crisiscore.www.weatherapp.net.models.sixteendaysforecastmodels.SixteenDaysWeatherData
import io.reactivex.Observable

interface Repository {

    fun getCurrentWeather(cityName: String): Observable<CurrentWeatherData>

    fun getFiveDaysForecastWeatherData(cityName: String): Observable<FiveDaysWeatherData>

    fun getSixteenDaysForecastWeatherData(cityName: String): Observable<SixteenDaysWeatherData>
}