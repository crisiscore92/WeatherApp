package com.crisiscore.www.weatherapp.repository.remote

import com.crisiscore.www.weatherapp.net.models.fivedaysforecastmodels.FiveDaysWeatherData
import com.crisiscore.www.weatherapp.repository.Repository
import com.crisiscore.www.weatherapp.repository.remote.specifications.FiveDaysWeatherDataObservableSpecification
import com.crisiscore.www.weatherapp.repository.remote.specifications.ObservableSpecification
import com.crisiscore.www.weatherapp.repository.Specification
import io.reactivex.Observable


class FiveDaysWeatherRepository: Repository<FiveDaysWeatherData> {

    override fun getWeatherData(specification: Specification, cityName: String): Observable<FiveDaysWeatherData> {
        val observableSpecification: ObservableSpecification<FiveDaysWeatherData> = specification as FiveDaysWeatherDataObservableSpecification

        return observableSpecification.getWeatherDataRemote(cityName)
    }
}