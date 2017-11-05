package com.crisiscore.www.weatherapp.net.models.fivedaysforecastmodels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Snow {

    @SerializedName("3h")
    @Expose
    var threeH:Double? = null

}
