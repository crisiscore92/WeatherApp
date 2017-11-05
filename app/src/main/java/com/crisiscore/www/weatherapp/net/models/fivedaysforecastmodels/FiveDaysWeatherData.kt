package com.crisiscore.www.weatherapp.net.models.fivedaysforecastmodels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class FiveDaysWeatherData {

    @SerializedName("cod")
    @Expose
    var cod: String? = null
    @SerializedName("message")
    @Expose
    var message: Double? = null
    @SerializedName("cnt")
    @Expose
    var cnt: Int? = null
    @SerializedName("list")
    @Expose
    var list: ArrayList<List>? = null
    @SerializedName("city")
    @Expose
    var city: City? = null
}
