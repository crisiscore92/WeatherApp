package com.crisiscore.www.weatherapp.net

import com.crisiscore.www.weatherapp.net.models.currentweathermodels.CurrentWeatherData
import com.crisiscore.www.weatherapp.net.models.fivedaysforecastmodels.FiveDaysWeatherData
import com.crisiscore.www.weatherapp.net.models.sixteendaysforecastmodels.SixteenDaysWeatherData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherServiceApi {

    @GET("weather?units=metric")
    fun getCurrentWeatherData(@Query("q") cityName: String,
                              @Query("appid") apiKey: String): Observable<CurrentWeatherData>

    @GET("forecast?units=metric")
    fun getFiveDaysForecastWeatherData(@Query("q") cityName: String,
                                       @Query("appid") apiKey: String): Observable<FiveDaysWeatherData>

    @GET("forecast/daily?units=metric")
    fun getSixteenDaysForecastWeatherData(@Query("q") cityName: String,
                                          @Query("appid") apiKey: String): Observable<SixteenDaysWeatherData>
}