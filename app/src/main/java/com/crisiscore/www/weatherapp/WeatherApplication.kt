package com.crisiscore.www.weatherapp

import android.app.Application
import com.crisiscore.www.weatherapp.data.preferences.Preferences
import com.crisiscore.www.weatherapp.di.*
import io.realm.Realm

class WeatherApplication: Application() {

    private lateinit var prefs: Preferences

    companion object {
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        prefs = Preferences(this)

        component = buildComponent()

        Realm.init(this)

        setFirstLaunch()
    }

    private fun setFirstLaunch() {
        if (prefs.isFirstLaunch()) {
            prefs.setFirstLaunch()
        }
    }

    private fun buildComponent(): AppComponent {
        return DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .weatherModule(WeatherModule())
                .preferencesModule(PreferencesModule())
                .conditionsCheckerModule(ConditionsCheckerModule())
                .build()
    }
}