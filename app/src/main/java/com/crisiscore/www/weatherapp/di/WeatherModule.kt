package com.crisiscore.www.weatherapp.di

import com.crisiscore.www.weatherapp.data.cache.WeatherDataSaver
import com.crisiscore.www.weatherapp.repository.local.CurrentWeatherRepositoryLocal
import com.crisiscore.www.weatherapp.repository.remote.CurrentWeatherRepository
import com.crisiscore.www.weatherapp.repository.remote.FiveDaysWeatherRepository
import com.crisiscore.www.weatherapp.repository.remote.SixteenDaysWeatherRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class WeatherModule {

    @Provides
    @Singleton
    fun provideCurrentWeatherRepository(): CurrentWeatherRepository = CurrentWeatherRepository()

    @Provides
    @Singleton
    fun provideFiveDaysWeatherRepository(): FiveDaysWeatherRepository = FiveDaysWeatherRepository()

    @Provides
    @Singleton
    fun provideSixteenDaysWeatherRepository(): SixteenDaysWeatherRepository = SixteenDaysWeatherRepository()

    @Provides
    @Singleton
    fun provideCurrentWeatherRepositoryLocal(): CurrentWeatherRepositoryLocal = CurrentWeatherRepositoryLocal()

    @Provides
    @Singleton
    fun provideWeatherDataSaver(): WeatherDataSaver = WeatherDataSaver()
}