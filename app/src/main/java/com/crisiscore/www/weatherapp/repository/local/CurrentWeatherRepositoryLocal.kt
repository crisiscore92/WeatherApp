package com.crisiscore.www.weatherapp.repository.local

import com.crisiscore.www.weatherapp.data.localmodels.currentweathermodels.*
import com.crisiscore.www.weatherapp.net.models.currentweathermodels.CurrentWeatherData
import com.crisiscore.www.weatherapp.repository.Repository
import com.crisiscore.www.weatherapp.repository.Specification
import com.crisiscore.www.weatherapp.repository.local.specifications.CurrentWeatherDataRealmSpecification
import com.crisiscore.www.weatherapp.repository.local.specifications.RealmSpecification
import io.reactivex.Observable
import io.realm.Realm


class CurrentWeatherRepositoryLocal: Repository<CurrentWeatherDataLocal> {

    override fun getWeatherData(specification: Specification, cityName: String): Observable<CurrentWeatherDataLocal> {
        val realmSpecification: RealmSpecification<CurrentWeatherDataLocal> = specification as CurrentWeatherDataRealmSpecification

        return realmSpecification.getWeatherData()
    }

    fun saveWeatherData(currentWeatherData: CurrentWeatherData) {
        val realm = Realm.getDefaultInstance()

        realm.executeTransaction({ realm ->
            val cloudsLocal = realm.createObject(CloudsLocal::class.java)
            cloudsLocal.all = currentWeatherData.clouds?.all

            val coordLocal = realm.createObject(CoordLocal::class.java)
            coordLocal.lat = currentWeatherData.coord?.lat
            coordLocal.lon = currentWeatherData.coord?.lon

            val mainLocal = realm.createObject(MainLocal::class.java)
            mainLocal.humidity = currentWeatherData.main?.humidity
            mainLocal.pressure = currentWeatherData.main?.pressure
            mainLocal.temp = currentWeatherData.main?.temp
            mainLocal.tempMax = currentWeatherData.main?.tempMax
            mainLocal.tempMin = currentWeatherData.main?.tempMin

            val sysLocal = realm.createObject(SysLocal::class.java)
            sysLocal.country = currentWeatherData.sys?.country
            sysLocal.sunrise = currentWeatherData.sys?.sunrise
            sysLocal.sunset = currentWeatherData.sys?.sunset

            val weatherLocal = realm.createObject(WeatherLocal::class.java)
            weatherLocal.main = currentWeatherData.weather?.get(0)?.main
            weatherLocal.description = currentWeatherData.weather?.get(0)?.description
            weatherLocal.icon = currentWeatherData.weather?.get(0)?.icon

            val windLocal = realm.createObject(WindLocal::class.java)
            windLocal.speed = currentWeatherData.wind?.speed

            val currentWeatherDataLocal = realm.createObject(CurrentWeatherDataLocal::class.java, System.currentTimeMillis())
            currentWeatherDataLocal.dt = currentWeatherData.dt
            currentWeatherDataLocal.cloudsLocal = cloudsLocal
            currentWeatherDataLocal.coordLocal = coordLocal
            currentWeatherDataLocal.mainLocal = mainLocal
            currentWeatherDataLocal.sysLocal = sysLocal
            currentWeatherDataLocal.weatherLocal?.add(weatherLocal)
            currentWeatherDataLocal.windLocal = windLocal
        })

        realm.close()
    }

    fun removeWeatherData() {
        val realm = Realm.getDefaultInstance()

        realm.executeTransaction({realm ->
            realm.where(CurrentWeatherDataLocal::class.java).findAll().deleteAllFromRealm()

        })
    }
}