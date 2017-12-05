package com.crisiscore.www.weatherapp.di

import com.crisiscore.www.weatherapp.repository.local.specifications.CurrentWeatherDataRealmSpecification
import com.crisiscore.www.weatherapp.repository.remote.specifications.CurrentWeatherDataObservableSpecification
import com.crisiscore.www.weatherapp.repository.remote.specifications.FiveDaysWeatherDataObservableSpecification
import com.crisiscore.www.weatherapp.repository.remote.specifications.SixteenDaysWeatherDataObservableSpecification
import com.crisiscore.www.weatherapp.ui.fivedaysforecast.FiveDaysForecastActivityPresenter
import com.crisiscore.www.weatherapp.ui.fivedaysforecast.fragments.dayfragment.DayFragment
import com.crisiscore.www.weatherapp.ui.fivedaysforecast.fragments.dayfragment.DayFragmentPresenter
import com.crisiscore.www.weatherapp.ui.mainactivity.MainActivityPresenter
import com.crisiscore.www.weatherapp.ui.sixteendaysforecast.SixteenDaysForecastActivityPresenter
import dagger.Component
import javax.inject.Singleton

@Component(modules = arrayOf(AppModule::class,
        WeatherModule::class,
        PreferencesModule::class,
        ConditionsCheckerModule::class,
        WeatherServiceModule::class))
@Singleton
interface AppComponent {

    fun inject(mainActivityPresenter: MainActivityPresenter)
    fun inject(fiveDaysForecastActivityPresenter: FiveDaysForecastActivityPresenter)
    fun inject(sixteenDaysForecastActivityPresenter: SixteenDaysForecastActivityPresenter)
    fun inject(currentWeatherDataObservableSpecification: CurrentWeatherDataObservableSpecification)
    fun inject(fiveDaysWeatherDataObservableSpecification: FiveDaysWeatherDataObservableSpecification)
    fun inject(sixteenDaysWeatherDataObservableSpecification: SixteenDaysWeatherDataObservableSpecification)
    fun inject(dayFragmentPresenter: DayFragmentPresenter)
}