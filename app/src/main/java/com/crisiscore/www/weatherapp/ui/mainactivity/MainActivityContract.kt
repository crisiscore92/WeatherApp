package com.crisiscore.www.weatherapp.ui.mainactivity

/**
 * Created by Aliaksandr Kotau on 05.11.2017.
 */
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