package com.crisiscore.www.weatherapp.repository

import io.reactivex.Observable

interface Repository<T> {

    fun getWeatherData(specification: Specification, cityName: String): Observable<T>
}