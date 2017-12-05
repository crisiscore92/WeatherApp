package com.crisiscore.www.weatherapp.repository.remote

import com.crisiscore.www.weatherapp.net.models.currentweathermodels.CurrentWeatherData
import com.crisiscore.www.weatherapp.repository.Repository
import com.crisiscore.www.weatherapp.repository.remote.specifications.CurrentWeatherDataObservableSpecification
import com.crisiscore.www.weatherapp.repository.remote.specifications.ObservableSpecification
import com.crisiscore.www.weatherapp.repository.Specification
import io.reactivex.Observable


class CurrentWeatherRepository: Repository<CurrentWeatherData> {

    override fun getWeatherData(specification: Specification, cityName: String): Observable<CurrentWeatherData> {
        val observableSpecification: ObservableSpecification<CurrentWeatherData> = specification as CurrentWeatherDataObservableSpecification

        return observableSpecification.getWeatherDataRemote(cityName)
    }
}