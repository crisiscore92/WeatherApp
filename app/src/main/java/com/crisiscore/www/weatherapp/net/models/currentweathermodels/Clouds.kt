package com.crisiscore.www.weatherapp.net.models.currentweathermodels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Clouds {

    @SerializedName("all")
    @Expose
    var all: Int? = null

}
