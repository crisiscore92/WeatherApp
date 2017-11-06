package com.crisiscore.www.weatherapp.ui.fivedaysforecast

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.crisiscore.www.weatherapp.R
import com.crisiscore.www.weatherapp.net.models.fivedaysforecastmodels.FiveDaysWeatherData

class FiveDaysForecastActivity :
        AppCompatActivity(),
        FiveDaysForecastActivityContract.View {

    private val presenter = FiveDaysForecastActivityPresenter(this)

    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_five_days_forecast)

        initViews()

        setSupportActionBar(toolbar)

        presenter.getFiveDaysForecastWeatherData()
    }

    private fun initViews() {
        toolbar = findViewById(R.id.toolbar)
    }

    override fun setFiveDaysForecastWeatherData(fiveDaysForecastWeatherData: FiveDaysWeatherData) {

    }
}
