package com.crisiscore.www.weatherapp.data.localmodels.currentweathermodels

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class CurrentWeatherDataLocal: RealmObject() {

    @PrimaryKey
    var _id: Long = 0
    var coordLocal: CoordLocal? = null
    var weatherLocal: RealmList<WeatherLocal>? = null
    var base: String? = null
    var mainLocal: MainLocal? = null
    var visibility: Int? = null
    var windLocal: WindLocal? = null
    var cloudsLocal: CloudsLocal? = null
    var dt: Int? = null
    var sysLocal: SysLocal? = null
    var id: Int? = null
    var name: String? = null
    var cod: Int? = null
}
