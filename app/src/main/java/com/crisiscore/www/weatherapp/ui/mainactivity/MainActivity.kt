package com.crisiscore.www.weatherapp.ui.mainactivity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.crisiscore.www.weatherapp.R
import com.crisiscore.www.weatherapp.ui.fivedaysforecast.FiveDaysForecastActivity

class MainActivity :
        AppCompatActivity(),
        MainActivityContract.View {

    private val presenter = MainActivityPresenter(this)

    private lateinit var helloWorldView: TextView
    private lateinit var button: Button
    private lateinit var imageView: ImageView
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        setSupportActionBar(toolbar)

        presenter.getCurrentTemperature()
        presenter.getWeatherIcon()
    }

    private fun initViews() {
        helloWorldView = findViewById(R.id.helloWorldView)

        button = findViewById(R.id.button)
        button.setOnClickListener {presenter.onButtonClick()}

        imageView = findViewById(R.id.imageView)

        toolbar = findViewById(R.id.toolbar)
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
}
