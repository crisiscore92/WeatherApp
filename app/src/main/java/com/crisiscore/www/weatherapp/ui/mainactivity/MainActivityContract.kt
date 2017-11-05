package com.crisiscore.www.weatherapp.ui.mainactivity

interface MainActivityContract {

    interface View {

        fun setCurrentTemperature(text: String)
        fun startFiveDaysForecastActivity()
    }

    interface Presenter {

        fun getCurrentTemperature()
        fun onButtonClick()
    }
}