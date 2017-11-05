package com.crisiscore.www.weatherapp.di

import com.crisiscore.www.weatherapp.ui.fivedaysforecast.FiveDaysForecastActivityPresenter
import com.crisiscore.www.weatherapp.ui.mainactivity.MainActivityPresenter
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Aliaksandr Kotau on 05.11.2017.
 */
@Component(modules = arrayOf(AppModule::class, WeatherModule::class))
@Singleton
interface AppComponent {

    fun inject(mainActivityPresenter: MainActivityPresenter)
    fun inject(fiveDaysForecastActivityPresenter: FiveDaysForecastActivityPresenter)
}