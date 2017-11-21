package com.crisiscore.www.weatherapp.di

import android.content.Context
import com.crisiscore.www.weatherapp.data.cache.WeatherDataSaver
import com.crisiscore.www.weatherapp.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class WeatherModule {

    @Provides
    @Singleton
    fun provideWeatherRepository(context: Context): WeatherRepository = WeatherRepository(context)

    @Provides
    @Singleton
    fun provideWeatherDataSaver(): WeatherDataSaver = WeatherDataSaver()
}