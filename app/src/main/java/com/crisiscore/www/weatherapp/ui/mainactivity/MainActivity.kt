package com.crisiscore.www.weatherapp.ui.mainactivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.crisiscore.www.weatherapp.R
import com.crisiscore.www.weatherapp.ui.base.DrawerActivity
import com.crisiscore.www.weatherapp.ui.fivedaysforecast.FiveDaysForecastActivity


class MainActivity :
        DrawerActivity(),
        MainActivityContract.View {

    private val presenter = MainActivityPresenter(this)

    private lateinit var helloWorldView: TextView
    private lateinit var button: Button
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val contentView = inflater.inflate(R.layout.activity_main, null, false)
        container.addView(contentView, 0)

        initViews()

        presenter.getCurrentTemperature()
        presenter.getWeatherIcon()
    }

    private fun initViews() {
        helloWorldView = findViewById(R.id.helloWorldView)

        button = findViewById(R.id.button)
        button.setOnClickListener {presenter.onButtonClick()}

        imageView = findViewById(R.id.imageView)
    }

    override fun setCurrentTemperature(text: String) {
        helloWorldView.text = text
    }

    override fun startFiveDaysForecastActivity() {
        startActivity(Intent(this, FiveDaysForecastActivity::class.java))
    }

    override fun setWeatherIcon(iconUrl: String?) {
        Glide.with(this).load(getString(R.string.basic_icon_url) + iconUrl).into(imageView)
    }

    override fun currentActivityName(): String = this::class.java.simpleName
}
