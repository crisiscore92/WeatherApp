package com.crisiscore.www.weatherapp.data.cache

import com.crisiscore.www.weatherapp.data.localmodels.currentweathermodels.CurrentWeatherDataLocal
import io.realm.Realm

class WeatherDataProvider {

    companion object {

        fun receiveCurrentWeatherData(): CurrentWeatherDataLocal? {
            val realm = Realm.getDefaultInstance()

            return realm.where(CurrentWeatherDataLocal::class.java).findFirst()
        }
    }
}