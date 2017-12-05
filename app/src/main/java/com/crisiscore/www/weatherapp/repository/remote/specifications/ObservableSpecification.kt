package com.crisiscore.www.weatherapp.repository.remote.specifications

import com.crisiscore.www.weatherapp.repository.Specification
import io.reactivex.Observable


interface ObservableSpecification<T>: Specification {

    fun getWeatherDataRemote(cityName: String): Observable<T>
}