package com.crisiscore.www.weatherapp.ui.fivedaysforecast

import android.content.Context
import android.preference.PreferenceManager
import com.crisiscore.www.weatherapp.WeatherApplication
import com.crisiscore.www.weatherapp.net.models.fivedaysforecastmodels.FiveDaysWeatherData
import com.crisiscore.www.weatherapp.net.models.fivedaysforecastmodels.List
import com.crisiscore.www.weatherapp.repository.remote.FiveDaysWeatherRepository
import com.crisiscore.www.weatherapp.repository.remote.specifications.FiveDaysWeatherDataObservableSpecification
import io.reactivex.Observable
import java.util.*
import javax.inject.Inject

class FiveDaysForecastActivityPresenter(private val view: FiveDaysForecastActivity):
        FiveDaysForecastActivityContract.Presenter {

    @Inject lateinit var repository: FiveDaysWeatherRepository
    @Inject lateinit var context: Context

    private val fiveDaysWeatherObservable: Observable<FiveDaysWeatherData>

    init {
        WeatherApplication.component.inject(this)

        fiveDaysWeatherObservable = repository.getWeatherData(FiveDaysWeatherDataObservableSpecification(),
                PreferenceManager.getDefaultSharedPreferences(context)
                        .getString("location", "Hrodna"))
    }

    override fun getDataForViewPagerDaysAdapter() {
        fiveDaysWeatherObservable.subscribe({fiveDaysWeatherData ->
            val receivedDateList = ArrayList<String>()
            val list = ArrayList<List>()
            if (fiveDaysWeatherData.list != null) {
                list.addAll(fiveDaysWeatherData.list!!)
            }
            for (i in list) {
                if (i.dtTxt != null) {
                    val day = i.dtTxt!!.split(" ")[0].split("-")[2]
                    val month = i.dtTxt!!.split(" ")[0].split("-")[1]
                    val date = day + "." + month
                    if (!receivedDateList.contains(date)) {
                        receivedDateList.add(date)
                    }
                }
            }

            view.setUpViewPagerDaysAdapter(receivedDateList)
        })
    }

}