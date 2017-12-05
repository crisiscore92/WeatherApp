package com.crisiscore.www.weatherapp.ui.mainactivity

import android.content.Context
import android.preference.PreferenceManager
import android.util.Log
import com.crisiscore.www.weatherapp.R
import com.crisiscore.www.weatherapp.WeatherApplication
import com.crisiscore.www.weatherapp.data.localmodels.currentweathermodels.CurrentWeatherDataLocal
import com.crisiscore.www.weatherapp.data.preferences.Preferences
import com.crisiscore.www.weatherapp.net.models.currentweathermodels.CurrentWeatherData
import com.crisiscore.www.weatherapp.repository.local.CurrentWeatherRepositoryLocal
import com.crisiscore.www.weatherapp.repository.local.specifications.CurrentWeatherDataRealmSpecification
import com.crisiscore.www.weatherapp.repository.remote.CurrentWeatherRepository
import com.crisiscore.www.weatherapp.repository.remote.specifications.CurrentWeatherDataObservableSpecification
import com.crisiscore.www.weatherapp.utils.ConditionsChecker
import io.reactivex.Observable
import javax.inject.Inject

class MainActivityPresenter(private val view: MainActivityContract.View):
        MainActivityContract.Presenter {

    @Inject lateinit var repositoryRemote: CurrentWeatherRepository
    @Inject lateinit var repositoryLocal: CurrentWeatherRepositoryLocal
    @Inject lateinit var conditionsChecker: ConditionsChecker
    @Inject lateinit var preferences: Preferences
    @Inject lateinit var context: Context

    private val currentWeatherObservableRemote: Observable<CurrentWeatherData>
    private lateinit var currentWeatherObservableLocal: Observable<CurrentWeatherDataLocal>

    init {
        WeatherApplication.component.inject(this)

        currentWeatherObservableRemote = repositoryRemote
                .getWeatherData(CurrentWeatherDataObservableSpecification(),
                        PreferenceManager.getDefaultSharedPreferences(context)
                        .getString("location", "Hrodna"))

        if (conditionsChecker.loadFromRemoteStorage()) {
            saveCurrentWeatherData()
        } else {
            currentWeatherObservableLocal = repositoryLocal
                    .getWeatherData(CurrentWeatherDataRealmSpecification(),
                            PreferenceManager.getDefaultSharedPreferences(context)
                            .getString("location", "Hrodna"))
        }
    }

    private fun saveCurrentWeatherData() {
        repositoryLocal.removeWeatherData()

        currentWeatherObservableRemote.subscribe({currentWeatherData ->
            repositoryLocal.saveWeatherData(currentWeatherData)
        })

        preferences.saveLastUpdateTimeMillis()
    }

    override fun getActivityTitle() {
        view.setActivityTitle(PreferenceManager.getDefaultSharedPreferences(context)
                .getString("location", "Hrodna"))
    }

    override fun forceLoadFromRemoteStorage() {
        saveCurrentWeatherData()
    }

    override fun getCurrentWeatherData() {
        if (conditionsChecker.loadFromRemoteStorage()) {
            Log.d("myLogs", "loading from remote storage")
            currentWeatherObservableRemote.subscribe({currentWeatherData ->
                view.setCurrentTemperature(getCurrentTemperatureRemote(currentWeatherData))
                view.setMainDescription(getMainDescriptionRemote(currentWeatherData))
                view.setWeatherIcon(getWeatherIconRemote(currentWeatherData))
                view.setWeatherConditions(getWeatherConditionsRemote(currentWeatherData))
            })
        } else {
            Log.d("myLogs", "loading from local storage")
            currentWeatherObservableLocal = repositoryLocal
                    .getWeatherData(CurrentWeatherDataRealmSpecification(), "Hrodna")

            currentWeatherObservableLocal.subscribe({currentWeatherDataLocal ->
                view.setCurrentTemperature(getCurrentTemperatureLocal(currentWeatherDataLocal))
                view.setMainDescription(getMainDescriptionLocal(currentWeatherDataLocal))
                view.setWeatherIcon(getWeatherIconLocal(currentWeatherDataLocal))
                view.setWeatherConditions(getWeatherConditionsLocal(currentWeatherDataLocal))
            })
        }
    }

    private fun getCurrentTemperatureRemote(currentWeatherData: CurrentWeatherData): String {
        return currentWeatherData.main?.temp?.toInt().toString() + " \u2103"
    }

    private fun getCurrentTemperatureLocal(currentWeatherDataLocal: CurrentWeatherDataLocal): String {
        return currentWeatherDataLocal.mainLocal?.temp?.toInt().toString() + " \u2103"
    }

    private fun getMainDescriptionRemote(currentWeatherData: CurrentWeatherData): String {
        return currentWeatherData.weather?.get(0)?.main.toString()
    }

    private fun getMainDescriptionLocal(currentWeatherDataLocal: CurrentWeatherDataLocal): String {
        return currentWeatherDataLocal.weatherLocal?.get(0)?.main.toString()
    }

    private fun getWeatherIconRemote(currentWeatherData: CurrentWeatherData): String {
        return currentWeatherData.weather?.get(0)?.icon + ".png"
    }

    private fun getWeatherIconLocal(currentWeatherDataLocal: CurrentWeatherDataLocal): String {
        return currentWeatherDataLocal.weatherLocal?.get(0)?.icon + ".png"
    }

    private fun getWeatherConditionsRemote(currentWeatherData: CurrentWeatherData): String {
        return (context.getString(R.string.humidity) + " "
                + currentWeatherData.main?.humidity + " %"
                + "\n"
                + context.getString(R.string.pressure) + " "
                + currentWeatherData.main?.pressure?.toInt() + " hPa"
                + "\n"
                + context.getString(R.string.wind) + " "
                + currentWeatherData.wind?.speed?.toInt() + " m/s")
    }

    private fun getWeatherConditionsLocal(currentWeatherDataLocal: CurrentWeatherDataLocal): String {
        return (context.getString(R.string.humidity) + " "
                + currentWeatherDataLocal.mainLocal?.humidity + " %"
                + "\n"
                + context.getString(R.string.pressure) + " "
                + currentWeatherDataLocal.mainLocal?.pressure?.toInt() + " hPa"
                + "\n"
                + context.getString(R.string.wind) + " "
                + currentWeatherDataLocal.windLocal?.speed?.toInt() + " m/s")
    }
}