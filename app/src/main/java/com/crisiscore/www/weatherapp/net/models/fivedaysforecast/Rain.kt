package com.crisiscore.www.weatherapp.net.models.fivedaysforecast

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Rain {

    @SerializedName("3h")
    @Expose
    var threeH:Double? = null

}
