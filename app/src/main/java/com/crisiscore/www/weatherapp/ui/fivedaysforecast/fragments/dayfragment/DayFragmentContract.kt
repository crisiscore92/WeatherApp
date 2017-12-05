package com.crisiscore.www.weatherapp.ui.fivedaysforecast.fragments.dayfragment


interface DayFragmentContract {

    interface View {

        fun setWeatherIcon(weatherIconPath: String)
        fun setTemperature(currentTemperature: String)
        fun setWeatherConditions(currentWeatherConditions: String)
    }

    interface Presenter {

        fun getCurrentWeatherData()
        fun getWeatherData(date: String)
    }
}