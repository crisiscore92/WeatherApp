package com.crisiscore.www.weatherapp.net.models.sixteendaysforecastmodels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class List {

    @SerializedName("dt")
    @Expose
    var dt: Int? = null
    @SerializedName("temp")
    @Expose
    var temp: Temp? = null
    @SerializedName("pressure")
    @Expose
    var pressure: Double? = null
    @SerializedName("humidity")
    @Expose
    var humidity: Int? = null
    @SerializedName("weather")
    @Expose
    var weather: ArrayList<Weather>? = null
    @SerializedName("speed")
    @Expose
    var speed: Double? = null
    @SerializedName("deg")
    @Expose
    var deg: Int? = null
    @SerializedName("clouds")
    @Expose
    var clouds: Int? = null
    @SerializedName("rain")
    @Expose
    var rain: Double? = null

}
