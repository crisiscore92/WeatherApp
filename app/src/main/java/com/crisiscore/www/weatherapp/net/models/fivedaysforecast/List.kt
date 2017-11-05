package com.crisiscore.www.weatherapp.net.models.fivedaysforecast

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlin.collections.List

class List {

    @SerializedName("dt")
    @Expose
    var dt: Int? = null
    @SerializedName("main")
    @Expose
    var main: Main? = null
    @SerializedName("weather")
    @Expose
    var weather: List<Weather>? = null
    @SerializedName("clouds")
    @Expose
    var clouds: Clouds? = null
    @SerializedName("wind")
    @Expose
    var wind: Wind? = null
    @SerializedName("sys")
    @Expose
    var sys: Sys? = null
    @SerializedName("dt_txt")
    @Expose
    var dtTxt: String? = null
    @SerializedName("rain")
    @Expose
    var rain: Rain? = null
    @SerializedName("snow")
    @Expose
    var snow: Snow? = null

}
