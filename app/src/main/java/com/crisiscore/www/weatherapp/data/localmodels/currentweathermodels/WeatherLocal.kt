package com.crisiscore.www.weatherapp.data.localmodels.currentweathermodels

import io.realm.RealmObject

open class WeatherLocal : RealmObject() {

    var id: Int? = null
    var main: String? = null
    var description: String? = null
    var icon: String? = null
}
