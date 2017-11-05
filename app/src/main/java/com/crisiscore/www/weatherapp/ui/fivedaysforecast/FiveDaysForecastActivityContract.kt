package com.crisiscore.www.weatherapp.ui.fivedaysforecast

import com.crisiscore.www.weatherapp.net.models.fivedaysforecastmodels.FiveDaysWeatherData

interface FiveDaysForecastActivityContract {

    interface View {

        fun setFiveDaysForecastWeatherData(fiveDaysForecastWeatherData: FiveDaysWeatherData)
    }

    interface Presenter {

        fun getFiveDaysForecastWeatherData()
    }
}