package com.crisiscore.www.weatherapp.ui.mainactivity

import com.crisiscore.www.weatherapp.WeatherApplication
import com.crisiscore.www.weatherapp.data.cache.WeatherDataProvider
import com.crisiscore.www.weatherapp.data.cache.WeatherDataSaver
import com.crisiscore.www.weatherapp.net.models.currentweathermodels.CurrentWeatherData
import com.crisiscore.www.weatherapp.repository.WeatherRepository
import io.reactivex.Observable
import javax.inject.Inject

class MainActivityPresenter(private val view: MainActivityContract.View):
        MainActivityContract.Presenter {

    @Inject
    lateinit var repository: WeatherRepository

    private val currentWeatherObservable: Observable<CurrentWeatherData>

    init {
        WeatherApplication.component.inject(this)

        currentWeatherObservable = repository.getCurrentWeather("Hrodna")

        saveCurrentWeatherData()
    }

    private fun saveCurrentWeatherData() {
        currentWeatherObservable.subscribe({weatherData -> WeatherDataSaver().saveCurrentWeatherData(weatherData)})
    }

    override fun getCurrentTemperature() {
        if (WeatherDataProvider().receiveCurrentWeatherData() != null) {
            view.setCurrentTemperature(WeatherDataProvider().receiveCurrentWeatherData()
                    ?.mainLocal
                    ?.temp?.toInt().toString() + " \u2103")
        } else {
            currentWeatherObservable.subscribe({weatherData -> view.setCurrentTemperature(weatherData
                    .main
                    ?.temp?.toInt().toString() + " \u2103")})
        }
    }

    override fun onButtonClick() {
        view.startFiveDaysForecastActivity()
    }

    override fun getWeatherIcon() {
        if (WeatherDataProvider().receiveCurrentWeatherData() != null) {
            view.setWeatherIcon(WeatherDataProvider().receiveCurrentWeatherData()
                    ?.weatherLocal
                    ?.get(0)
                    ?.icon + ".png")
        } else {
            currentWeatherObservable.subscribe({weatherData -> view.setWeatherIcon(weatherData
                    .weather
                    ?.get(0)
                    ?.icon + ".png")})
        }
    }
}