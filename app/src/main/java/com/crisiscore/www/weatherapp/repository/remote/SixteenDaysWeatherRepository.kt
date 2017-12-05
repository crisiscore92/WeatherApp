package com.crisiscore.www.weatherapp.repository.remote

import com.crisiscore.www.weatherapp.net.models.sixteendaysforecastmodels.SixteenDaysWeatherData
import com.crisiscore.www.weatherapp.repository.Repository
import com.crisiscore.www.weatherapp.repository.remote.specifications.ObservableSpecification
import com.crisiscore.www.weatherapp.repository.remote.specifications.SixteenDaysWeatherDataObservableSpecification
import com.crisiscore.www.weatherapp.repository.Specification
import io.reactivex.Observable


class SixteenDaysWeatherRepository: Repository<SixteenDaysWeatherData> {

    override fun getWeatherData(specification: Specification, cityName: String): Observable<SixteenDaysWeatherData> {
        val observableSpecification: ObservableSpecification<SixteenDaysWeatherData> = specification as SixteenDaysWeatherDataObservableSpecification

        return observableSpecification.getWeatherDataRemote(cityName)
    }
}