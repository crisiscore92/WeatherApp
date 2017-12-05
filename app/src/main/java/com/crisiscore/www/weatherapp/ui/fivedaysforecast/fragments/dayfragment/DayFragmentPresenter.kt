package com.crisiscore.www.weatherapp.ui.fivedaysforecast.fragments.dayfragment

import android.content.Context
import android.preference.PreferenceManager
import android.util.Log
import com.crisiscore.www.weatherapp.R
import com.crisiscore.www.weatherapp.WeatherApplication
import com.crisiscore.www.weatherapp.net.models.currentweathermodels.CurrentWeatherData
import com.crisiscore.www.weatherapp.net.models.fivedaysforecastmodels.FiveDaysWeatherData
import com.crisiscore.www.weatherapp.net.models.fivedaysforecastmodels.List
import com.crisiscore.www.weatherapp.repository.remote.CurrentWeatherRepository
import com.crisiscore.www.weatherapp.repository.remote.FiveDaysWeatherRepository
import com.crisiscore.www.weatherapp.repository.remote.specifications.CurrentWeatherDataObservableSpecification
import com.crisiscore.www.weatherapp.repository.remote.specifications.FiveDaysWeatherDataObservableSpecification
import javax.annotation.Nullable
import javax.inject.Inject


class DayFragmentPresenter(private val view: DayFragment):
        DayFragmentContract.Presenter {

    @Inject lateinit var fiveDaysWeatherRepository: FiveDaysWeatherRepository
    @Inject lateinit var currentWeatherRepository: CurrentWeatherRepository
    @Inject lateinit var context: Context

    init {
        WeatherApplication.component.inject(this)
    }

    override fun getCurrentWeatherData() {
        currentWeatherRepository.getWeatherData(CurrentWeatherDataObservableSpecification(),
                PreferenceManager.getDefaultSharedPreferences(context)
                        .getString("location", "Hrodna"))
                .subscribe({currentWeatherData ->
                    view.setWeatherIcon(getCurrentWeatherDataIcon(currentWeatherData))
                    view.setTemperature(getCurrentTemperature(currentWeatherData))
                    view.setWeatherConditions(getCurrentWeatherConditions(currentWeatherData))
                })
    }

    override fun getWeatherData(date: String) {
        fiveDaysWeatherRepository.getWeatherData(FiveDaysWeatherDataObservableSpecification(),
                PreferenceManager.getDefaultSharedPreferences(context)
                .getString("location", "Hrodna"))
                .subscribe({fiveDaysWeatherData ->
                    view.setWeatherIcon(getWeatherDataIcon(fiveDaysWeatherData, date))
                })
    }

    private fun getCurrentWeatherDataIcon(currentWeatherData: CurrentWeatherData): String {
        return currentWeatherData.weather?.get(0)?.icon + ".png"
    }

    private fun getCurrentTemperature(currentWeatherData: CurrentWeatherData): String {
        return currentWeatherData.main?.temp?.toInt().toString() + " \u2103"
    }

    private fun getCurrentWeatherConditions(currentWeatherData: CurrentWeatherData): String {
        return (context.getString(R.string.humidity) + " "
                + currentWeatherData.main?.humidity + " %"
                + "\n"
                + context.getString(R.string.pressure) + " "
                + currentWeatherData.main?.pressure + " hPa"
                + "\n"
                + context.getString(R.string.wind) + " "
                + currentWeatherData.wind?.speed + " m/s")
    }

    private fun getWeatherDataIcon(fiveDaysWeatherData: FiveDaysWeatherData, date: String): String {

        val list = fiveDaysWeatherData.list ?: return ""

        var weatherIconPath = ""
        var day: String
        val dayParam = date.split(".")[0]

        for (weatherListItem in list) {

            weatherIconPath = weatherListItem.weather?.get(0)?.icon ?: ""
            day = weatherListItem.dtTxt?.split(" ")?.get(0)?.split("-")?.get(2) ?: ""

            if ((day == dayParam) && weatherIconPath.contains("d")) {
                weatherIconPath += ".png"
                break
            }
        }

        return weatherIconPath
    }

    private fun getTemperature(currentWeatherData: CurrentWeatherData): String {
        return currentWeatherData.main?.temp?.toInt().toString() + " \u2103"
    }

    private fun getWeatherConditions(currentWeatherData: CurrentWeatherData): String {
        return (context.getString(R.string.humidity) + " "
                + currentWeatherData.main?.humidity + " %"
                + "\n"
                + context.getString(R.string.pressure) + " "
                + currentWeatherData.main?.pressure + " hPa"
                + "\n"
                + context.getString(R.string.wind) + " "
                + currentWeatherData.wind?.speed + " m/s")
    }
}