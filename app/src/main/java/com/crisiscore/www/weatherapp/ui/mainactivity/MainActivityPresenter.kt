package com.crisiscore.www.weatherapp.ui.mainactivity

import com.crisiscore.www.weatherapp.WeatherApplication
import com.crisiscore.www.weatherapp.repository.WeatherRepository
import javax.inject.Inject

/**
 * Created by Aliaksandr Kotau on 05.11.2017.
 */
class MainActivityPresenter(private var view: MainActivityContract.View) : MainActivityContract.Presenter {

    @Inject
    lateinit var repository: WeatherRepository

    init {
        WeatherApplication.component.inject(this)
    }

    override fun getCurrentTemperature() {
        repository.getCurrentWeather("Hrodna")
                .subscribe({weatherData -> view.setCurrentTemperature(weatherData.main?.temp.toString())})
    }

    override fun onButtonClick() {
        view.startFiveDaysForecastActivity()
    }
}