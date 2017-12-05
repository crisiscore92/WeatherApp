package com.crisiscore.www.weatherapp.ui.fivedaysforecast.fragments.dayfragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.crisiscore.www.weatherapp.R
import com.crisiscore.www.weatherapp.ui.fivedaysforecast.adapters.ViewPagerWeatherElementsAdapter

import kotlinx.android.synthetic.main.item_five_days_forecast.*

class DayFragment:
        Fragment(),
        DayFragmentContract.View {

    private val presenter: DayFragmentPresenter = DayFragmentPresenter(this)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.item_five_days_forecast, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        weatherDetailsPager.adapter = ViewPagerWeatherElementsAdapter(childFragmentManager)
        weatherDetailsTabs.setupWithViewPager(weatherDetailsPager)

        if (arguments != null && arguments.getBoolean("firstPage")) {
            presenter.getCurrentWeatherData()
        } else if (arguments != null) {
            presenter.getWeatherData(arguments.getString("date"))
        }
    }

    override fun setWeatherIcon(weatherIconPath: String) {
        Glide.with(this).load(getString(R.string.basic_icon_url) + weatherIconPath)
                .into(fiveDaysForecastCurrentWeatherIcon)
    }

    override fun setTemperature(currentTemperature: String) {
        fiveDaysWeatherForecastCurrentTemperature.text = currentTemperature
    }

    override fun setWeatherConditions(currentWeatherConditions: String) {
        fiveDaysForecastCurrentWeatherConditions.text = currentWeatherConditions
    }
}