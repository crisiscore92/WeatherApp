package com.crisiscore.www.weatherapp.data.localmodels.currentweathermodels
import io.realm.RealmObject

open class SysLocal : RealmObject() {

    var type: Int? = null
    var id: Int? = null
    var message: Double? = null
    var country: String? = null
    var sunrise: Int? = null
    var sunset: Int? = null
}
