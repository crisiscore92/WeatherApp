package com.crisiscore.www.weatherapp.ui.mainactivity

import com.crisiscore.www.weatherapp.WeatherApplication
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
    }

    override fun getCurrentTemperature() {
        currentWeatherObservable.subscribe({weatherData -> view.setCurrentTemperature(weatherData
                .main
                ?.temp.toString())})
    }

    override fun onButtonClick() {
        view.startFiveDaysForecastActivity()
    }

    override fun getWeatherIcon() {
        currentWeatherObservable.subscribe({weatherData -> view.setWeatherIcon(weatherData
                .weather
                ?.get(0)
                ?.icon + ".png")})
    }
}