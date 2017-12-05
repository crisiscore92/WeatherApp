package com.crisiscore.www.weatherapp.di

import android.content.Context
import com.crisiscore.www.weatherapp.data.preferences.Preferences
import com.crisiscore.www.weatherapp.utils.ConditionsChecker
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ConditionsCheckerModule {

    @Provides
    @Singleton
    fun provideConditionsChecker(context: Context, preferences: Preferences): ConditionsChecker {
        return ConditionsChecker(context, preferences)
    }
}