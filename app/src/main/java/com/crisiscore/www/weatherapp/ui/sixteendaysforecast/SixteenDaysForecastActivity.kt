package com.crisiscore.www.weatherapp.ui.sixteendaysforecast

import android.app.Activity
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import com.crisiscore.www.weatherapp.R
import com.crisiscore.www.weatherapp.ui.base.DrawerActivity

class SixteenDaysForecastActivity:
        DrawerActivity(),
        SixteenDaysForecastActivityContract.View {

    private val presenter = SixteenDaysForecastActivityPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val contentView = inflater.inflate(R.layout.activity_sixteen_days_forecast, null, false)
        container.addView(contentView, 0)

        initViews()
    }

    private fun initViews() {
    }

    override fun currentActivityName(): String {
        return this::class.java.simpleName
    }
}
