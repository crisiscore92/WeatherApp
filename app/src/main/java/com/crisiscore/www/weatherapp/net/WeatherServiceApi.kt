package com.crisiscore.www.weatherapp.net

import com.crisiscore.www.weatherapp.net.models.currentweather.CurrentWeatherData
import com.crisiscore.www.weatherapp.net.models.fivedaysforecast.FiveDaysWeatherData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Aliaksandr Kotau on 05.11.2017.
 */
interface WeatherServiceApi {

    @GET("weather?")
    fun getCurrentWeatherData(@Query("q") cityName: String,
                              @Query("appid") apiKey: String): Observable<CurrentWeatherData>

    @GET("forecast?")
    fun getFiveDaysForecastWeatherData(@Query("q") cityName: String,
                                       @Query("appid") apiKey: String): Observable<FiveDaysWeatherData>
}