package com.crisiscore.www.weatherapp.ui.sixteendaysforecast

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.crisiscore.www.weatherapp.R

class SixteenDaysForecastActivity:
        AppCompatActivity(),
        SixteenDaysForecastActivityContract.View {

    private val presenter = SixteenDaysForecastActivityPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sixteen_days_forecast)
    }
}
