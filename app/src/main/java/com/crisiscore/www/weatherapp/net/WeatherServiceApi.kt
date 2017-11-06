package com.crisiscore.www.weatherapp.net

import com.crisiscore.www.weatherapp.net.models.currentweathermodels.CurrentWeatherData
import com.crisiscore.www.weatherapp.net.models.fivedaysforecastmodels.FiveDaysWeatherData
import com.crisiscore.www.weatherapp.net.models.sixteendaysforecastmodels.SixteenDaysWeatherData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherServiceApi {

    @GET("weather?")
    fun getCurrentWeatherData(@Query("q") cityName: String,
                              @Query("appid") apiKey: String): Observable<CurrentWeatherData>

    @GET("forecast?")
    fun getFiveDaysForecastWeatherData(@Query("q") cityName: String,
                                       @Query("appid") apiKey: String): Observable<FiveDaysWeatherData>

    @GET("forecast/daily?")
    fun getSixteenDaysForecastWeatherData(@Query("q") cityName: String,
                                          @Query("appid") apiKey: String): Observable<SixteenDaysWeatherData>
}