package com.crisiscore.www.weatherapp.ui.sixteendaysforecast

import com.crisiscore.www.weatherapp.WeatherApplication
import com.crisiscore.www.weatherapp.repository.remote.SixteenDaysWeatherRepository
import javax.inject.Inject

class SixteenDaysForecastActivityPresenter(private val view: SixteenDaysForecastActivity):
        SixteenDaysForecastActivityContract.Presenter {

    @Inject
    lateinit var repository: SixteenDaysWeatherRepository

    init {
        WeatherApplication.component.inject(this)
    }
}