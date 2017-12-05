package com.crisiscore.www.weatherapp.repository.local.specifications

import com.crisiscore.www.weatherapp.WeatherApplication
import com.crisiscore.www.weatherapp.data.localmodels.currentweathermodels.CurrentWeatherDataLocal
import com.crisiscore.www.weatherapp.repository.remote.CurrentWeatherRepository
import io.reactivex.Observable
import io.realm.Realm
import javax.inject.Inject


class CurrentWeatherDataRealmSpecification: RealmSpecification<CurrentWeatherDataLocal> {

    override fun getWeatherData(): Observable<CurrentWeatherDataLocal> {
        val realm = Realm.getDefaultInstance()

        return Observable.just(realm.where(CurrentWeatherDataLocal::class.java).findFirst())
    }
}