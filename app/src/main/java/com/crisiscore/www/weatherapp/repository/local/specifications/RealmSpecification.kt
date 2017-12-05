package com.crisiscore.www.weatherapp.repository.local.specifications

import com.crisiscore.www.weatherapp.repository.Specification
import io.reactivex.Observable


interface RealmSpecification<T>: Specification {

    fun getWeatherData(): Observable<T>
}