package com.crisiscore.www.weatherapp.ui.fivedaysforecast

import com.crisiscore.www.weatherapp.WeatherApplication
import com.crisiscore.www.weatherapp.repository.WeatherRepository
import javax.inject.Inject

/**
 * Created by Aliaksandr Kotau on 05.11.2017.
 */
class FiveDaysForecastActivityPresenter(private var view: FiveDaysForecastActivity): FiveDaysForecastActivityContract.Presenter {

    @Inject
    lateinit var repository: WeatherRepository

    init {
        WeatherApplication.component.inject(this)
    }

    override fun getFiveDaysForecastWeatherData() {
        repository.getFiveDaysForecastWeatherData("Hrodna")
                .subscribe({fiveDaysForecastWeatherData -> view.setFiveDaysForecastWeatherData(fiveDaysForecastWeatherData)})
    }
}