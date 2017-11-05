package com.crisiscore.www.weatherapp.ui.mainactivity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.crisiscore.www.weatherapp.R
import com.crisiscore.www.weatherapp.ui.fivedaysforecast.FiveDaysForecastActivity

class MainActivity :
        AppCompatActivity(),
        MainActivityContract.View {

    private val presenter = MainActivityPresenter(this)

    private lateinit var helloWorldView: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        presenter.getCurrentTemperature()
    }

    private fun initViews() {
        helloWorldView = findViewById(R.id.helloWorldView)
        button = findViewById(R.id.button)
        button.setOnClickListener {presenter.onButtonClick()}
    }

    override fun setCurrentTemperature(text: String) {
        helloWorldView.text = text
    }

    override fun startFiveDaysForecastActivity() {
        startActivity(Intent(this, FiveDaysForecastActivity::class.java))
    }
}
