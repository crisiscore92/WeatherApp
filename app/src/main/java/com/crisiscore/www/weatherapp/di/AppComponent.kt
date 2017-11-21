package com.crisiscore.www.weatherapp.di

import com.crisiscore.www.weatherapp.repository.WeatherRepository
import com.crisiscore.www.weatherapp.ui.fivedaysforecast.FiveDaysForecastActivityPresenter
import com.crisiscore.www.weatherapp.ui.mainactivity.MainActivityPresenter
import com.crisiscore.www.weatherapp.ui.sixteendaysforecast.SixteenDaysForecastActivityPresenter
import dagger.Component
import javax.inject.Singleton

@Component(modules = arrayOf(AppModule::class, WeatherModule::class))
@Singleton
interface AppComponent {

    fun inject(mainActivityPresenter: MainActivityPresenter)
    fun inject(fiveDaysForecastActivityPresenter: FiveDaysForecastActivityPresenter)
    fun inject(sixteenDaysForecastActivityPresenter: SixteenDaysForecastActivityPresenter)
    fun inject(weatherRepository: WeatherRepository)
}