package com.crisiscore.www.weatherapp.di

import android.content.Context
import com.crisiscore.www.weatherapp.data.preferences.Preferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class PreferencesModule {

    @Provides
    @Singleton
    fun providePreferences(context: Context): Preferences {
        return Preferences(context)
    }
}