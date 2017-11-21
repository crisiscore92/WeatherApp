package com.crisiscore.www.weatherapp.data.localmodels.currentweathermodels
import io.realm.RealmObject

open class MainLocal: RealmObject() {

    var temp: Double? = null
    var pressure: Double? = null
    var humidity: Int? = null
    var tempMin: Double? = null
    var tempMax: Double? = null

}
