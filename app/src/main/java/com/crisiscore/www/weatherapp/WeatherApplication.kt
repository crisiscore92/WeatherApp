package com.crisiscore.www.weatherapp

import android.app.Application
import com.crisiscore.www.weatherapp.di.AppComponent
import com.crisiscore.www.weatherapp.di.AppModule
import com.crisiscore.www.weatherapp.di.DaggerAppComponent
import com.crisiscore.www.weatherapp.di.WeatherModule

/**
 * Created by Aliaksandr Kotau on 05.11.2017.
 */
class WeatherApplication: Application() {

    companion object {
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        component = buildComponent()
    }

    private fun buildComponent(): AppComponent {
        return DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .weatherModule(WeatherModule())
                .build()
    }
}