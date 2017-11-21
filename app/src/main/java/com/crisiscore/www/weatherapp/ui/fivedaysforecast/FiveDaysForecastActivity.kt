package com.crisiscore.www.weatherapp.ui.fivedaysforecast

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import com.crisiscore.www.weatherapp.R
import com.crisiscore.www.weatherapp.net.models.fivedaysforecastmodels.FiveDaysWeatherData
import com.crisiscore.www.weatherapp.ui.base.DrawerActivity

class FiveDaysForecastActivity :
        DrawerActivity(),
        FiveDaysForecastActivityContract.View {

    private val presenter = FiveDaysForecastActivityPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val contentView = inflater.inflate(R.layout.activity_five_days_forecast, null, false)
        container.addView(contentView, 0)

        initViews()

        presenter.getFiveDaysForecastWeatherData()
    }

    private fun initViews() {
    }

    override fun setFiveDaysForecastWeatherData(fiveDaysForecastWeatherData: FiveDaysWeatherData) {

    }

    override fun currentActivityName(): String = this::class.java.simpleName
}
