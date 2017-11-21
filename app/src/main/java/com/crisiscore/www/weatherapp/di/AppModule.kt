package com.crisiscore.www.weatherapp.di

import android.content.Context
import android.support.annotation.NonNull
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(@NonNull context: Context) {

    private val appContext: Context = context

    @Provides
    @Singleton
    fun provideContext(): Context = appContext
}