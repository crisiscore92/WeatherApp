package com.crisiscore.www.weatherapp.di

import android.content.Context
import com.crisiscore.www.weatherapp.R
import com.crisiscore.www.weatherapp.net.WeatherServiceApi
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class WeatherServiceModule {

    @Provides
    @Singleton
    fun weatherServiceApiProvider(context: Context): WeatherServiceApi {
        val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(context.getString(R.string.basic_weather_url))
                .build()

        return retrofit.create(WeatherServiceApi::class.java)
    }
}