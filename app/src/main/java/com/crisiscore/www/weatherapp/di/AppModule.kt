package com.crisiscore.www.weatherapp.di

import android.content.Context
import android.support.annotation.NonNull
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Aliaksandr Kotau on 05.11.2017.
 */
@Module
class AppModule(@NonNull context: Context) {

    private val appContext: Context = context

    @Provides
    @Singleton
    fun provideContext(): Context {
        return appContext
    }
}