package com.crisiscore.www.weatherapp.repository

import android.content.Context
import com.crisiscore.www.weatherapp.R
import com.crisiscore.www.weatherapp.net.WeatherServiceApi
import com.crisiscore.www.weatherapp.net.models.currentweather.CurrentWeatherData
import com.crisiscore.www.weatherapp.net.models.fivedaysforecast.FiveDaysWeatherData
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Aliaksandr Kotau on 05.11.2017.
 */
class WeatherRepository(private val context: Context): Repository {

    private val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(context.getString(R.string.basic_weather_url))
            .build()

    private val weatherService = retrofit.create(WeatherServiceApi::class.java)

    override fun getCurrentWeather(cityName: String): Observable<CurrentWeatherData> {
        return weatherService.getCurrentWeatherData(cityName, context.getString(R.string.api_key))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getFiveDaysForecastWeatherData(cityName: String): Observable<FiveDaysWeatherData> {
        return weatherService.getFiveDaysForecastWeatherData(cityName, context.getString(R.string.api_key))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }
}