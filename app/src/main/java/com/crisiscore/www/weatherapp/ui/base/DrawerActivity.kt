package com.crisiscore.www.weatherapp.ui.base

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.LinearLayout
import com.crisiscore.www.weatherapp.R
import com.crisiscore.www.weatherapp.ui.fivedaysforecast.FiveDaysForecastActivity
import com.crisiscore.www.weatherapp.ui.mainactivity.MainActivity
import com.crisiscore.www.weatherapp.ui.settings.SettingsActivity
import com.crisiscore.www.weatherapp.ui.sixteendaysforecast.SixteenDaysForecastActivity
import kotlinx.android.synthetic.main.activity_drawer.*
import kotlinx.android.synthetic.main.app_bar_drawer.*

abstract class DrawerActivity: AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    protected lateinit var container: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)
        setSupportActionBar(toolbar)

        initDrawerLayout()
    }

    private fun initDrawerLayout() {
        container = findViewById(R.id.container)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.current_forecast -> {
                if (currentActivityName() != MainActivity::class.java.simpleName) {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
            }
            R.id.five_days_forecast -> {
                if (currentActivityName() != FiveDaysForecastActivity::class.java.simpleName) {
                    startActivity(Intent(this, FiveDaysForecastActivity::class.java))
                    finish()
                }
            }
            R.id.sixteen_days_forecast -> {
                if (currentActivityName() != SixteenDaysForecastActivity::class.java.simpleName) {
                    startActivity(Intent(this, SixteenDaysForecastActivity::class.java))
                    finish()
                }
            }
            R.id.settings -> {
                if (currentActivityName() != SettingsActivity::class.java.simpleName) {
                    startActivity(Intent(this, SettingsActivity::class.java))
                    finish()
                }
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    abstract fun currentActivityName(): String
}
