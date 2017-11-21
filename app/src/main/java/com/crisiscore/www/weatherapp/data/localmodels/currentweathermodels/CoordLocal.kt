package com.crisiscore.www.weatherapp.data.localmodels.currentweathermodels

import io.realm.RealmObject

open class CoordLocal : RealmObject() {

    var lon: Double? = null
    var lat: Double? = null

}
