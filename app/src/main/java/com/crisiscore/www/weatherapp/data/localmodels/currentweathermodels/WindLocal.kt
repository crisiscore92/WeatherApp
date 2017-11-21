package com.crisiscore.www.weatherapp.data.localmodels.currentweathermodels

import io.realm.RealmObject

open class WindLocal : RealmObject() {

    var speed: Double? = null
    var deg: Double? = null
}
