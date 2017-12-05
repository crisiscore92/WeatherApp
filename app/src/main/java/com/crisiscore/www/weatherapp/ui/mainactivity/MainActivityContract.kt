package com.crisiscore.www.weatherapp.ui.mainactivity

interface MainActivityContract {

    interface View {

        fun setCurrentTemperature(text: String)
        fun setMainDescription(mainDescription: String)
        fun setWeatherIcon(iconUrl: String?)
        fun setActivityTitle(title: String)
        fun setWeatherConditions(weatherConditions: String)
    }

    interface Presenter {

        fun getActivityTitle()
        fun forceLoadFromRemoteStorage()
        fun getCurrentWeatherData()
    }
}