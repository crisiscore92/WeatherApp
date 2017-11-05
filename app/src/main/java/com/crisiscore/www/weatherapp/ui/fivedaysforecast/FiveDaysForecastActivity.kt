package com.crisiscore.www.weatherapp.ui.fivedaysforecast

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.crisiscore.www.weatherapp.R
import com.crisiscore.www.weatherapp.net.models.fivedaysforecastmodels.FiveDaysWeatherData

class FiveDaysForecastActivity :
        AppCompatActivity(),
        FiveDaysForecastActivityContract.View {

    private val presenter = FiveDaysForecastActivityPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_five_days_forecast)

        presenter.getFiveDaysForecastWeatherData()
    }

    override fun setFiveDaysForecastWeatherData(fiveDaysForecastWeatherData: FiveDaysWeatherData) {

    }
}
