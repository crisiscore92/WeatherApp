package com.crisiscore.www.weatherapp.data.preferences

import android.content.Context
import android.content.SharedPreferences


class Preferences(val context: Context) {

    private val preferencesTitle: String = "preferences"

    private val updateTimeMillisKey: String = "update_time_millis_key"
    private val isFirsLaunchKey: String = "is_first_launch_key"

    private val sharedPreferences: SharedPreferences

    init {
        sharedPreferences = context.getSharedPreferences(preferencesTitle, Context.MODE_PRIVATE)
    }

    fun saveLastUpdateTimeMillis() {
        val editor = sharedPreferences.edit()
        editor.putLong(updateTimeMillisKey, System.currentTimeMillis())
        editor.apply()
    }

    fun loadLastUpdateTimeMillis(): Long {
        return sharedPreferences.getLong(updateTimeMillisKey, 0)
    }

    fun setFirstLaunch() {
        val editor = sharedPreferences.edit()
        editor.putBoolean(isFirsLaunchKey, false)
        editor.apply()
    }

    fun isFirstLaunch(): Boolean {
        return sharedPreferences.getBoolean(isFirsLaunchKey, true)
    }
}