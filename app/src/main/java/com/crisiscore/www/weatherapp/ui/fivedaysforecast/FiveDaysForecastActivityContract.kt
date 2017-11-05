package com.crisiscore.www.weatherapp.ui.fivedaysforecast

import com.crisiscore.www.weatherapp.net.models.fivedaysforecast.FiveDaysWeatherData

/**
 * Created by Aliaksandr Kotau on 05.11.2017.
 */
interface FiveDaysForecastActivityContract {

    interface View {

        fun setFiveDaysForecastWeatherData(fiveDaysForecastWeatherData: FiveDaysWeatherData)
    }

    interface Presenter {

        fun getFiveDaysForecastWeatherData()
    }
}