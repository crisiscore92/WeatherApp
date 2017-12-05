package com.crisiscore.www.weatherapp.ui.mainactivity

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import com.bumptech.glide.Glide
import com.crisiscore.www.weatherapp.R
import com.crisiscore.www.weatherapp.ui.base.SwipeRefreshActivity

import kotlinx.android.synthetic.main.activity_main.*


class MainActivity :
        SwipeRefreshActivity(),
        MainActivityContract.View {

    private val presenter = MainActivityPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val contentView = inflater.inflate(R.layout.activity_main, null, false)
        swipeRefreshContainer.addView(contentView, 0)

        presenter.getActivityTitle()
        presenter.getCurrentWeatherData()
    }

    override fun setCurrentTemperature(text: String) {
        temperatureView.text = text
    }

    override fun setMainDescription(mainDescription: String) {
        mainDescriptionView.text = mainDescription
    }

    override fun setWeatherIcon(iconUrl: String?) {
        Glide.with(this).load(getString(R.string.basic_icon_url) + iconUrl).into(imageView)
    }

    override fun setActivityTitle(title: String) {
        setTitle(title)
    }

    override fun setWeatherConditions(weatherConditions: String) {
        weatherConditionsView.text = weatherConditions
    }

    override fun currentActivityName(): String = this::class.java.simpleName

    override fun onRefresh() {
        super.onRefresh()
        presenter.forceLoadFromRemoteStorage()
        presenter.getCurrentWeatherData()
    }
}
