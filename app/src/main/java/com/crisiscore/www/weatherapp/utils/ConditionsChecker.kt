package com.crisiscore.www.weatherapp.utils

import android.content.Context
import android.net.ConnectivityManager
import android.preference.PreferenceManager
import com.crisiscore.www.weatherapp.data.localmodels.currentweathermodels.CurrentWeatherDataLocal
import com.crisiscore.www.weatherapp.data.preferences.Preferences
import io.realm.Realm


class ConditionsChecker(val context: Context, private val preferences: Preferences) {

    private val listPreferenceKey: String = "update_intervals"

    private val toMillis = 60 * 1000

    private val defaultUpdatePeriod = "60"

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

    private fun isCurrentWeatherDataLocalAvailable(): Boolean {
        val realm = Realm.getDefaultInstance()
        return realm.where(CurrentWeatherDataLocal::class.java).count() > 0
    }

    private fun isUpdateTimeElapsed(): Boolean {
        return System.currentTimeMillis() > (preferences.loadLastUpdateTimeMillis() +
                        PreferenceManager.getDefaultSharedPreferences(context)
                                .getString(listPreferenceKey, defaultUpdatePeriod)
                                .toLong() * toMillis)
    }

    fun loadFromRemoteStorage(): Boolean {
        return ((isNetworkAvailable() && isUpdateTimeElapsed())
                || (isNetworkAvailable() && !isUpdateTimeElapsed() && !isCurrentWeatherDataLocalAvailable()))
    }
}