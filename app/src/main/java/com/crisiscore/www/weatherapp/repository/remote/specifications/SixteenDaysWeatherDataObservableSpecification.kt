package com.crisiscore.www.weatherapp.repository.remote.specifications

import android.content.Context
import com.crisiscore.www.weatherapp.R
import com.crisiscore.www.weatherapp.WeatherApplication
import com.crisiscore.www.weatherapp.net.WeatherServiceApi
import com.crisiscore.www.weatherapp.net.models.sixteendaysforecastmodels.SixteenDaysWeatherData
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class SixteenDaysWeatherDataObservableSpecification : ObservableSpecification<SixteenDaysWeatherData> {

    @Inject
    lateinit var weatherService: WeatherServiceApi

    @Inject
    lateinit var context: Context

    init {
        WeatherApplication.component.inject(this)
    }

    private fun <T> Observable<T>.applySchedulers(): Observable<T> {
        return subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getWeatherDataRemote(cityName: String): Observable<SixteenDaysWeatherData> {
        return weatherService.getSixteenDaysForecastWeatherData(cityName, context.getString(R.string.api_key))
                .applySchedulers()
    }
}